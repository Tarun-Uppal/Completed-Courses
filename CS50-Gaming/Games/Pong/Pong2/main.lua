WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 720

VIRTUAL_WIDTH = 432
VIRTUAL_HEIGHT = 243

smallFont = love.graphics.newFont('04B_03__.TTF', 8)
scoreFont = love.graphics.newFont('04B_03__.TTF', 32)

player1score = 0
player2score = 0

PADDLE_SPEED = 200

push = require 'push'


function love.load()
    love.graphics.setDefaultFilter('nearest','nearest')
 
    player1Y = 30
    player2Y = VIRTUAL_HEIGHT - 40

    push:setupScreen(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, WINDOW_WIDTH, WINDOW_HEIGHT, {
        fullscreen = false,
        vsync = true,
        resizeable = false
    })
end

function love.update(dt)
    if love.keyboard.isDown('w') then
        player1Y = player1Y - PADDLE_SPEED * dt
    elseif love.keyboard.isDown('s') then
        player1Y = player1Y + PADDLE_SPEED * dt
    end
    if love.keyboard.isDown('up') then
        player2Y = player2Y - PADDLE_SPEED * dt
    elseif love.keyboard.isDown('down') then
        player2Y = player2Y + PADDLE_SPEED * dt
    end    
end

function love.keypressed(key)
    if key == 'escape' then
        love.event.quit()
    end
end


function love.draw()
    push:apply('start')

    love.graphics.clear(40 / 255, 45 / 255, 52 / 255, 255 / 255)

    love.graphics.rectangle('fill', VIRTUAL_WIDTH / 2 - 2.5, VIRTUAL_HEIGHT / 2 - 2.5, 5, 5)
    love.graphics.rectangle('fill', 10, player1Y, 5, 20)
    love.graphics.rectangle('fill', VIRTUAL_WIDTH - 10, player2Y, 5, 20)

    love.graphics.setFont(smallFont)
    love.graphics.printf("Hello Pong", 0, 20, VIRTUAL_WIDTH, 'center')

    love.graphics.setFont(scoreFont)
    love.graphics.print(player1score, VIRTUAL_WIDTH / 2 - 50, VIRTUAL_HEIGHT / 3)
    love.graphics.print(player2score, VIRTUAL_WIDTH / 2 + 30, VIRTUAL_HEIGHT / 3)

 
    push:apply('end')
end