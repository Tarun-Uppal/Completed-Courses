Map = Class{}

require 'Util'

TILE_BRICK = 2
TILE_EMPTY = 1
TILE_START = 3
TILE_END = 4
TILE_CIRCLE = 5

count = 0

function Map:init()
    count = 0
    self.tileWidth = 16
	self.tileHeight = 16
	self.mapWidth = 1280 / self.tileWidth
    self.mapHeight = 720 / self.tileHeight
	
	self.spritesheet = love.graphics.newImage('pictures/image.png')
	self.sprites = generateQuads(self.spritesheet, self.tileWidth, self.tileHeight)
	
    self.tiles = {}
    self.routetiles = {}

    self.route = false

    self:generateMap()
    
    self:render()
end

-- generates a map
function Map:generateMap()
    while true do
        -- seeds the rng
        math.randomseed(os.time())
        while true do
            self:reset()
            -- generates the route 
            self:generateRoute(1, self.mapHeight - 1, self.mapWidth, 2, false)
            -- counts the number moves it took
            count = self:countMoves()
            if count <= 150 then
                break
            end
        end

        -- fills up the rest of the map
        self:generateRandom()
        -- generates the borders of the map
        self:generateBoundaries()

        -- sets the end tile
        self:setTile(self.mapWidth, 2, TILE_END)
        -- sets the end tile
        self:setTile(self.mapWidth, 2, TILE_END, true)
        -- sets the start tile
        self:setTile(1, self.mapHeight - 1, TILE_START)
        -- sets the start tile
        self:setTile(1, self.mapHeight - 1, TILE_START, true)

        if self:countMoves() <= (self.mapHeight * self.mapWidth) / 2 then
            break
        end  
    end
    -- renders the map
    self:render(true)
end

function Map:reset()
    -- sets up the map
    for y = 1, self.mapHeight do
        for x = 1, self.mapWidth do
            self:setTile(x, y,TILE_BRICK)
        end
    end
end

-- generates a random route to follow
function Map:generateRoute(startX, startY, endX, endY, long)
    self.tiles = {}
    self.routetiles = {}
    -- sets the starting cordinates
    local posX = startX + 1
    local posY = startY

    -- sets the first tile
    self:setTile(posX, posY, TILE_EMPTY)
    self:setTile(posX, posY, TILE_EMPTY, true)
    previous_move = 0
    -- randomly generates the way
    while ((posX ~= endX) and (posY ~= endY)) do
        -- choses the next move
        next_move = math.random(4)
        -- choses the number of times the next move will take place
        next_move_count = math.random(3)
        previous_move = next_move
        for i = 1, next_move_count do
            -- moves right
            if ((next_move == 1) and (self:checkboundaries(posX + 1, posY) == false)) then
                posX = posX + 1
                self:setTile(posX, posY, TILE_EMPTY)
                self:setTile(posX, posY, TILE_EMPTY, true)
            -- moves up
            elseif ((next_move == 2) and (self:checkboundaries(posX, posY - 1) == false)) then
                posY = posY - 1
                self:setTile(posX, posY, TILE_EMPTY)
                self:setTile(posX, posY, TILE_EMPTY, true)
            -- moves down
            elseif ((next_move == 3) and (self:checkboundaries(posX, posY + 1) == false)) then
                posY = posY + 1
                self:setTile(posX, posY, TILE_EMPTY)
                self:setTile(posX, posY, TILE_EMPTY, true)
            else
                break
            end
        end
    end
    -- if it dosen't finish with the x axis then it completes it
    if posX < endX then
        while posX ~= endX do
            self:setTile(posX, posY, TILE_EMPTY)
            self:setTile(posX, posY, TILE_EMPTY, true)
            posX = posX + 1
        end
    end
    -- if it dosen't finish with the y axis then it completes it
    if posY > endY then
        while posY ~= endY do
            self:setTile(posX, posY, TILE_EMPTY)
            self:setTile(posX, posY, TILE_EMPTY, true)
            posY = posY + 1
        end
    end
end

function Map:countMoves()
    -- sets up the counter
    local count1 = 0
    -- goes through the map
    for y = 1, self.mapHeight do
        for x = 1, self.mapWidth do
            local tile = self:getTile(x, y)
            if tile == TILE_EMPTY then
                count1 = count1 + 1
            end
        end
    end
    return count1
end


-- checks if the given cordinates overlap with the end of then map or boundarires
function Map:checkboundaries(x, y) 
    if ((x > self.mapWidth - 1) or (x <= 1) or (y > self.mapHeight - 1) or (y <= 1)) then
        return true
    else
        return false
    end  
end

-- generates the border of the map
function Map:generateBoundaries()
    -- generates boundaries along the x axis
    y1 = 1
    y2 = self.mapHeight
    for x = 1, self.mapWidth do
        self:setTile(x, y1, TILE_BRICK)
        self:setTile(x, y2, TILE_BRICK)
    end

    -- generates boundaries along the y axis
    x1 = 1
    x2 = self.mapWidth
    for y = 1, self.mapHeight do
        self:setTile(x1, y, TILE_BRICK)
        self:setTile(x2, y, TILE_BRICK)
    end
end

-- randomly fills the map with blocks
function Map:generateRandom()
    -- goes through the width of the map
    for x = 1, self.mapWidth do
        -- goes through the height of the map
        for y = 1, self.mapHeight do
            -- if the current tile is not part of the generated path the randomly fills the map
            if self:getTile(x, y) ~= TILE_EMPTY then
                if math.random(2003) < 1187 then
                    self:setTile(x, y, TILE_BRICK)
                else
                    self:setTile(x, y, TILE_EMPTY)
                end
            end
        end
    end
end

-- returns an integer value for the tile at a given x-y coordinate
function Map:getTile(x, y)
    -- if the player wants to show the route then it returns the tile from the route array 
    if self.route == true then
        return self.routetiles[(y - 1) * self.mapWidth + x]
    else
        return self.tiles[(y - 1) * self.mapWidth + x]
    end
end

-- sets a tile at a given x-y coordinate to an integer value
function Map:setTile(x, y, id, route)
    -- if the player wants to setup the route then it sets the routetiles array rather than the tile array
    if route == true then
        self.routetiles[(y - 1) * self.mapWidth + x] = id
    else
        self.tiles[(y - 1) * self.mapWidth + x] = id
    end
end

-- renders the map
function Map:render()
    -- goes through the height
    for y = 1, self.mapHeight do
        -- goes through the width
        for x = 1, self.mapWidth do
            -- gets the current tile
            local tile = self:getTile(x, y)
            -- checks if it has to show the route and the tile is nil
            if self.route == true and tile == nil then
                tile = TILE_BRICK
                self:setTile(x, y, TILE_BRICK, true)
            end
            -- if the tile is not empty the it draws it
            if tile ~= TILE_EMPTY then
                love.graphics.draw(self.spritesheet, self.sprites[tile],
                    (x - 1) * self.tileWidth, (y - 1) * self.tileHeight)
            end
        end
    end
end

-- prints the move aim
function Map:load()
    -- love.graphics.printf(count, 0, 10, WINDOW_WIDTH, 'left')
end

-- gets the tile using the real x and y axis
function Map:getAbsoluteTile(x, y)
    -- converts both to the maps axis
    -- returns the tile
    return self:getTile(math.floor(x / self.tileHeight, 0.001) + 1, math.floor(y / self.tileWidth, 0.001) + 1, self.route)
end

-- sets the route
function Map:setRoute(route1) 
    self.route = route1
    self:render()
end

-- returns the place on the x axis where it is part of the route
function Map:playerOnXAxis(y)
    -- converts the y axis into which the maps y axis
    y = math.floor(y / self.tileHeight, 0.001) + 1
    -- goes through the width of the map
    for x = 1, self.mapWidth do
        -- gets the current tile into the route and checks if it is empty
        if self:getTile(x, y) == TILE_EMPTY then
            -- returns the real pixel value for the player
            return (x - 1) * self.tileHeight
        end
    end
end

-- returns the place on the y axis where it is part of the route
function Map:playerOnYAxis(x)
    -- converts the x axis into which the maps x axis
    x = math.floor(x / self.tileHeight, 0.001) + 1
    -- goes through the height of the map
    for y = 1, self.mapHeight do
        -- gets the current tile into the route and checks if it is empty
        if self:getTile(x, y) == TILE_EMPTY then
            -- returns the real pixel value for the player
            return (y - 1) * self.tileHeight
        end
    end
end