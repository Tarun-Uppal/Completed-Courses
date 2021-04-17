WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 720

VIRTUAL_WIDTH = 432
VIRTUAL_HEIGHT = 243

smallFont = love.graphics.newFont('04B_03__.TTF', 8)
scoreFont = love.graphics.newFont('04B_03__.TTF', 32)

player1score = 0
player2score = 0

PADDLE_SPEED = 200

Class = require 'class'
push = require 'push'

require 'Ball'
require 'Paddle'

function love.load()
    math.randomseed(os.time())
    love.graphics.setDefaultFilter('nearest','nearest')
 
    paddle1 = Paddle(5, 20, 5, 20)
    paddle2 = Paddle(VIRTUAL_WIDTH - 10, VIRTUAL_HEIGHT - 30, 5, 20 )

    ball = Ball(VIRTUAL_WIDTH /2 - 2, VIRTUAL_HEIGHT / 2 - 2, 5, 5)

    push:setupScreen(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, WINDOW_WIDTH, WINDOW_HEIGHT, {
        fullscreen = false,
        vsync = true,
        resizeable = false
    })

    gameState = 'start'
end

function love.update(dt)

    paddle1:update(dt)
    paddle2:update(dt)

    if love.keyboard.isDown('w') then
        paddle1.dy = -PADDLE_SPEED
    elseif love.keyboard.isDown('s') then
        paddle1.dy = PADDLE_SPEED
    else
        paddle1.dy = 0
    end
    if love.keyboard.isDown('up') then
        paddle2.dy = -PADDLE_SPEED
    elseif love.keyboard.isDown('down') then
        paddle2.dy = PADDLE_SPEED
    else 
        paddle2.dy = 0
    end

    if gameState == 'play' then
        ball:update(dt)
    end
end

function love.keypressed(key)
    if key == 'escape' then
        love.event.quit()
    elseif key == 'enter' or key == 'return' then
        if gameState == 'start' then
            gameState = 'play'
        elseif gameState == 'play' then
            gameState = 'start'
            ball:reset()
        end
    end
end


function love.draw()
    push:apply('start')

    love.graphics.clear(40 / 255, 45 / 255, 52 / 255, 255 / 255)

    ball:render()

    paddle1:render()
    paddle2:render()
    
    love.graphics.setFont(smallFont)
    if gameState == 'start' then
        love.graphics.printf("Hello Start State", 0, 20, VIRTUAL_WIDTH, 'center')
    elseif gameState == 'play' then
        love.graphics.printf("Hello Play State", 0, 20, VIRTUAL_WIDTH, 'center')
    end
    
    love.graphics.setFont(scoreFont)
    love.graphics.print(player1score, VIRTUAL_WIDTH / 2 - 50, VIRTUAL_HEIGHT / 3)
    love.graphics.print(player2score, VIRTUAL_WIDTH / 2 + 30, VIRTUAL_HEIGHT / 3)

 
    push:apply('end')
end