WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 720

VIRTUAL_WIDTH = 432
VIRTUAL_HEIGHT = 243

push = require 'push'
Class = require 'class'

require 'Util'
require 'Map'

function love.load()
    math.randomseed(os.time())

    map = Map()

    love.graphics.setDefaultFilter('nearest', 'nearest')

    push:setupScreen(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, WINDOW_WIDTH, WINDOW_HEIGHT, {
        fullscreen = false,
        resizable = false, 
        vsync = true
    })

    love.keyboard.keysPressed = {}
end

function love.keyboard.wasPressed(key)
    if (love.keyboard.keysPressed[key]) then
        return true
    else
        return false
    end
end

function love.update(dt)
    map:update(dt)

    love.keyboard.keysPressed = {}
end

function love.draw()
    push:apply('start')
    love.graphics.clear(108/255, 140/255, 1, 1)

    love.graphics.translate(math.floor(-map.camX + 0.5), math.floor(-map.camY))
    map:render()
    push:apply('end')
end

function love.keypressed(key)
    if key == 'escape' then
        love.event.quit()
    end
    love.keyboard.keysPressed[key] = true
end