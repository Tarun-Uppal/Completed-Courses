Player = Class{}

-- sets the window width and height
WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 720

-- sets the tiles from the quads array
TILE_BRICK = 2
TILE_CIRCLE = 5

-- stores the move count
currentCount = 0

function Player:init()
	-- resets the counter
	currentCount = 0
	-- sets the tile width
	self.tileWidth = 16
	-- sets the tile height
	self.tileHeight = 16
	-- sets the map width
	self.mapWidth = 1280
	-- sets the map height
	self.mapHeight = 720

	-- sets the walking speed
	self.walkingSpeed = 250
	-- sets the positions
	self.x = 0
	self.y = self.mapHeight - 32

	-- sets the x and y axis for the next time render is called
	tempX = self.x
	tempY = self.y

	-- sets the state to start
	self.state = 'start'
	self.restart = false

	-- loads the sprites into memory
	self.spritesheet = love.graphics.newImage('pictures/image.png')
	-- generates the drawable quads
	self.sprites = generateQuads(self.spritesheet, self.tileWidth, self.tileHeight)

	currentCount = 0
	-- renders the player
	self:render()
end

-- renders the player
function Player:render()
	-- if the current cordinates are not equal to the previous one that means that the position has changed and the counter must be incremented
	if ((math.floor(self.x / (self.tileWidth)) * self.tileWidth ~= tempX) or (math.floor(self.y / (self.tileHeight)) * self.tileHeight ~= tempY)) and self.restart == false then
		currentCount = currentCount + 1
	end
	-- draws the circle
	love.graphics.draw(self.spritesheet, self.sprites[TILE_CIRCLE],
		math.floor(self.x / (self.tileWidth)) * self.tileWidth, math.floor(self.y / (self.tileHeight)) * self.tileHeight)
	
	-- sets the x and y axis for the next time render is called
	tempX = math.floor(self.x / (self.tileWidth)) * self.tileWidth
	tempY = math.floor(self.y / (self.tileHeight)) * self.tileHeight
end

-- updates the tiles
function Player:update(tiles, dt, toUpdate)
	-- if the player is playing
	if self.state == 'playing' then
		self.restart = false
		-- handles moving right
		if love.keyboard.isDown('right') and self:collides(tiles, self.x + (self.walkingSpeed * dt), self.y) then
			self.x = self.x + (self.walkingSpeed * dt)
		-- handles moving left
		elseif love.keyboard.isDown('left') and self:collides(tiles, self.x - (self.walkingSpeed * dt), self.y) then
			self.x = self.x - (self.walkingSpeed * dt)
		-- handles moving up
		elseif love.keyboard.isDown('up') and self:collides(tiles, self.x, self.y - (self.walkingSpeed * dt)) then
			self.y = self.y - (self.walkingSpeed * dt)
		-- handles moving down 
		elseif love.keyboard.isDown('down') and self:collides(tiles, self.x, self.y + (self.walkingSpeed * dt)) then
			self.y = self.y + (self.walkingSpeed * dt)
		end
	-- checks if space is down and the player is in the end state
	elseif love.keyboard.isDown('space') and self.state == 'end' then
		currentCount = 0
		self.state = 'start' 
		self.restart = true
	-- if the player is in the start state
	elseif self.state == 'start' then
		self.state = 'playing'
	end
	if toUpdate == false then
		currentCount = 0
	end
	self:render()
end

-- checks if the player is colliding with anything
function Player:collides(map, x, y)
	currentX = math.floor(x, 0.001)
	currentY = math.floor(y, 0.001)

	-- checks if the player collides with a brick from the map
	if map:getAbsoluteTile(currentX, currentY) == TILE_BRICK then
		return false
	-- checks if the player is at the end of the map on any side
	elseif currentX <= 0 or currentY <= 0 or currentX >= self.mapWidth or currentY >= self.mapHeight then
		return false
	-- checks if the player is at the greeen flag
	elseif currentX >= (self.mapWidth - 16) and currentX <= self.mapWidth and currentY <= 32 and currentY >= 16 then
		self.state = 'end'
		return true
	-- if the player is at the start of the map
	elseif self:isOnStart(self.x, self.y) == false then
		self.state = 'start'
		return true
	else
		return true
	end
end

function Player:isOnStart(x, y)
	currentX = math.floor(x, 0.001)
	currentY = math.floor(y, 0.001)
	if currentX >= 0 and currentX <= 16 and currentY >= self.mapHeight - 32 and currentY <= self.mapHeight - 16 then
		return true
	else
		return false
	end
end

-- loads the messages
function Player:load() 
	-- prints the ending message
	if self.state == 'end' then
		love.graphics.printf('The game is over! Press space to restart', 0, 10, WINDOW_WIDTH, 'center')
	end
	-- prints the counter
	love.graphics.printf("Move count = " .. currentCount, 0, 30, WINDOW_WIDTH, 'left')
end

function Player:getCount()
	return currentCount
end