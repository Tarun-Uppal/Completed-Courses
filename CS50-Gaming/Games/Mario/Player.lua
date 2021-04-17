Player = Class{}

require 'Animation'

local MOVE_SPEED = 80
local JUMP_VELOCITY = 400
local GRAVITY = 40
JUMP_BLOCK_HIT = 9
JUMP_BLOCK = 5

function Player:init(map)
    self.width = 16
    self.height = 20
    self.map = map
    self.x = self.map.tileWidth * 10
    self.y = self.map.tileHeight * (self.map.mapHeight / 2 - 1) - self.height

    self.dx = 0
    self.dy = 0

    self.texture = love.graphics.newImage('graphics/blue_alien.png')
    self.frames = generateQuads(self.texture, 16, 20)

    self.state = 'idle'
    self.direction = 'right'

    self.animations = {
        ['idle'] = Animation {
            texture = self.texture, 
            frames = {
                self.frames[1]
            },
            interval = 1
        },
        ['walking'] = Animation {
            texture = self.texture, 
            frames = {
                self.frames[9], self.frames[10], self.frames[11]
            },
            interval = 0.15
        }, 
        ['jumping'] = Animation{
            texture = self.texture, 
            frames = {
                self.frames[3]
            }, 
            interval = 1
        }
    }

    self.animation = self.animations['idle']

    self.behaviors = {
        ['idle'] = function(dt)
            if love.keyboard.wasPressed('space') then
                self.dy = -JUMP_VELOCITY
                self.state = 'jumping'
                self.animation = self.animations['jumping']
            elseif love.keyboard.isDown('a') then
                self.dx = -MOVE_SPEED
                self.animation = self.animations['walking'] 
                self.direction = 'left'
            elseif love.keyboard.isDown('d') then
                self.dx = MOVE_SPEED
                self.animation = self.animations['walking'] 
                self.direction = 'right'
            else
                self.dx = 0
            end
        end,
        ['walking'] = function(dt)   
            if love.keyboard.wasPressed('space') then
                self.dy = -JUMP_VELOCITY
                self.state = 'jumping'
                self.animation = self.animations['jumping']         
            elseif love.keyboard.isDown('a') then
                self.dx = -MOVE_SPEED
                self.direction = 'left'
            elseif love.keyboard.isDown('d') then
                self.dx = MOVE_SPEED
                self.direction = 'right'
            else
                self.dx = 0
                self.state = 'idle'
                self.animation = self.animations[self.state]
            end

            self:checkRightCollision()
            self:checkLeftCollision()

            if not self.map:collides(self.map:tileAt(self.x, self.y + self.height)) and
                not self.map:collides(self.map:tileAt(self.x + self.width - 1, self.y + self.height)) then
                self.state = 'jumping'
                self.animation = self.animations[self.state]
            end
        end,
        ['jumping'] = function(dt)
            if self.y > 300 then
                return
            end
            if love.keyboard.isDown('a') then
                self.direction = 'left'
                self.dx = -MOVE_SPEED
            elseif love.keyboard.isDown('d') then
                self.direction = 'right'
                self.dx = MOVE_SPEED
            end

            self.dy = self.dy + GRAVITY

            self:checkRightCollision()
            self:checkLeftCollision()

            if self.map:collides(self.map:tileAt(self.x, self.y + self.height)) or
            self.map:collides(self.map:tileAt(self.x + self.width - 1, self.y + self.height)) then
                self.dy = 0
                self.state = 'idle'
                self.animation = self.animations[self.state]
                self.y = (self.map:tileAt(self.x, self.y + self.height).y - 1) * self.map.tileHeight - self.height
            end
            
        end
    }
end

function Player:update(dt)
    self.behaviors[self.state](dt)
    self.animation:update(dt)
    self.x = self.x + self.dx * dt
    self.y = self.y + self.dy * dt

    if self.dy < 0 then
        if self.map:tileAt(self.x, self.y) ~= TILE_EMPTY or 
        self.map:tileAt(self.x + self.width - 1, self.y) ~= TILE_EMPTY then
            self.dy = 0
            if self.map:tileAt(self.x, self.y) == JUMP_BLOCK then
                self.map:setTile(math.floor(self.x / self.map.tileWidth) + 1,
                    math.floor(self.y / self.map.tileHeight) + 1, JUMP_BLOCK_HIT) 
            end
            if self.map:tileAt(self.x + self.width - 1, self.y) == JUMP_BLOCK then
                self.map:setTile(math.floor((self.x + self.width - 1) / self.map.tileWidth) + 1, 
                    math.floor(self.y / self.map.tileHeight) + 1, JUMP_BLOCK_HIT)
            end
        end
    end
end

function Player:render()
    local scaleX = 1
    if self.direction == 'right' then
        scaleX = 1
    else
        scaleX = -1
    end
    love.graphics.draw(self.texture, self.animation:getCurrentFrame(), math.floor(self.x + self.width / 2), math.floor(self.y + self.height / 2), 
        0, scaleX, 1, self.width / 2, self.height / 2)
end

function Player:checkLeftCollision()
    if self.dx > 0 then
        if self.map:collides(self.map:tileAt(self.x - 1, self.y)) or
        self.map:collides(self.map:tileAt(self.x - 1, self.y + self.height - 1)) then
            self.dx = 0
            self.x = self.map:tileAt(self.x - 1, self.y)* self.x * self.map.tileWidth
        end
    end
end

function Player:checkRightCollision()
    if self.dy > 0 then
        if self.map:collides(self.map:tileAt(self.x + self.width, self.y)) or
        self.map:collides(self.map:tileAt(self.x + self.width, self.y + self.height - 1)) then
            self.dx = 0
            -- self.x = (self.map:tileAt(self.x + self.width, self.y).x - 1) * self.map.tileWidth - self.width
            self.x = (self.map:tileAt(self.x + self.width, self.y).x - 1) * self.map.tileWidth - self.width
        end
    end
end