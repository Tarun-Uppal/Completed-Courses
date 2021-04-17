Map = Class{}

TILE_BRICK = 1
TILE_EMPTY = -1

-- cloud tiles
CLOUD_LEFT = 6
CLOUD_RIGHT = 7

-- bush tiles
BUSH_LEFT = 2
BUSH_RIGHT = 3

-- mushroom tiles
MUSHROOM_TOP = 10
MUSHROOM_BOTTOM = 11

-- jump block
JUMP_BLOCK = 5
JUMP_BLOCK_HIT = 9

VIRTUAL_WIDTH = 432
VIRTUAL_HEIGHT = 243

local SCROLL_SPEED = 62

camX = 0
camY = -3

mapHeightPixels = 0
mapWidthPixels = 0

require 'Player'

player = nil

function Map:init()
    self.spritesheet = love.graphics.newImage('graphics/spritesheet.png')
    self.tileWidth = 16
    self.tileHeight = 16
    self.mapWidth = 30
    self.mapHeight = 20
    self.tiles = {}

    player = Player(self)
    
    self.tileSprites = generateQuads(self.spritesheet, self.tileWidth, self.tileHeight)

    mapWidthPixels = self.mapWidth * self.tileWidth
    mapHeightPixels = self.mapHeight * self.tileHeight

    -- -- filling the map with empty tiles
    for y = 1, self.mapHeight do
        for x = 1, self.mapWidth do
            self:setTile(x, y, TILE_EMPTY) 
        end
    end

    local x = 1
    while x < self.mapWidth do
        -- 2% chance to generate a cloud
        -- make sure were 2 tiles from the edge at least
        if x < self.mapWidth - 2 then
            if math.random(20) == 1 then
                local cloudStart = math.random(self.mapHeight / 2 - 6)
                
                self:setTile(x, cloudStart, CLOUD_LEFT)
                self:setTile(x + 1, cloudStart, CLOUD_RIGHT)
            end
        end
        -- 5% chance to generate a mushroom
        if math.random(20) == 1 then
            -- left side of the pipe
            self:setTile(x, self.mapHeight / 2 - 2, MUSHROOM_TOP)
            self:setTile(x, self.mapHeight / 2 - 1, MUSHROOM_BOTTOM)

            -- creates column of tiles going to the bottom of the map
            for y = self.mapHeight / 2, self.mapHeight do
                self:setTile(x, y, TILE_BRICK)
            end
            -- next vertical scan line
            x = x + 1

        -- 10% chance to generate bush, being sure to generate away from edge
        elseif math.random(10) == 1 and x < self.mapWidth - 3 then
            local bushLevel = self.mapHeight / 2 - 1
            
            -- place bush component and then column of bricks
            self:setTile(x, bushLevel, BUSH_LEFT)
            for y = self.mapHeight / 2, self.mapHeight do
                self:setTile(x, y, TILE_BRICK)
            end
            x = x + 1

            self:setTile(x, bushLevel, BUSH_RIGHT)
            for y = self.mapHeight / 2, self.mapHeight do
                self:setTile(x, y, TILE_BRICK)
            end
            x = x + 1

        elseif math.random(10) ~= 1 then
            for y = self.mapHeight / 2 , self.mapHeight do
                self:setTile(x, y, TILE_BRICK)
            end
            if math.random(15) == 1 then
                self:setTile(x, self.mapHeight / 2 - 4, JUMP_BLOCK)
            end

            x = x + 1
        else 
            x = x + 2
        end
    end

    -- starts halfway down the map, populates with bricks
    for y = self.mapHeight / 2, self.mapHeight do
        for x = 1, self.mapWidth do
            self:setTile(x, y, TILE_BRICK)
        end
    end
end

function Map:setTile(x, y, tile)
    self.tiles[(y - 1) * self.mapWidth + x] = tile
end

function Map:getTile(x, y)
    return self.tiles[(y - 1) * self.mapWidth + x]
end

function Map:update(dt)
    camX = math.max(0, 
        math.min(player.x - VIRTUAL_WIDTH / 2, 
        math.min(mapWidthPixels - VIRTUAL_WIDTH, player.x)))

    player:update(dt)

    self.camX = camX
    self.camY = camY
end

function Map:tileAt(x, y)
    return self:getTile(math.floor(x / self.tileWidth) + 1, math.floor(y / self.tileHeight) + 1)
end

function Map:render()
    for y = 1, self.mapHeight do
        for x = 1, self.mapWidth do
            love.graphics.draw(self.spritesheet, self.tileSprites[self:getTile(x, y)], (x - 1) * self.tileWidth, (y - 1) * self.tileHeight) 
        end
    end
    player:render()
end

function Map:collides(tile) 
    local collidables = {
        TILE_BRICK, JUMP_BLOCK, JUMP_BLOCK_HIT,
        MUSHROOM_TOP, MUSHROOM_BOTTOM
    }

    for _, v in ipairs(collidables) do
        -- if tile.id == v then
        if tile.id == v then
            return true
        end
    end
    return false
end