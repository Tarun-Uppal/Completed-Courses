WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 720

VIRTUAL_WIDTH = 432
VIRTUAL_HEIGHT = 243

smallFont = love.graphics.newFont('04B_03__.TTF', 8)
scoreFont = love.graphics.newFont('04B_03__.TTF', 32)

player1score = 0
player2score = 0

PADDLE_SPEED = 200

searvingPlayer = math.random(2) == 1 and 1 or 2   

Class = require 'class'
push = require 'push'

require 'Ball'
require 'Paddle'

function love.load()
    math.randomseed(os.time())
    love.graphics.setDefaultFilter('nearest','nearest')
 
    love.window.setTitle("Pong")
    paddle1 = Paddle(5, 20, 5, 20)
    paddle2 = Paddle(VIRTUAL_WIDTH - 10, VIRTUAL_HEIGHT - 30, 5, 20)

    ball = Ball(VIRTUAL_WIDTH /2 - 2, VIRTUAL_HEIGHT / 2 - 2, 5, 5)

    if searvingPlayer == 1 then
        ball.dx = 100
    else
        ball.dx = -100
    end

    push:setupScreen(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, WINDOW_WIDTH, WINDOW_HEIGHT, {
        fullscreen = false,
        vsync = true,
        resizeable = false
    })

    gameState = 'start'
end

function love.update(dt)
    if gameState == 'play' then

        if ball:collides(paddle1) then
            ball.dx = -ball.dx
        end

        if ball:collides(paddle2) then
            ball.dx = -ball.dx
        end

        if ball.y <= 0 then
            ball.dy = -ball.dy
            ball.y = 0
        end

        if ball.y >= VIRTUAL_HEIGHT - 4 then
            ball.dy = -ball.dy
            ball.y = VIRTUAL_HEIGHT - 4
        end

        if ball.x <= 0 then
            player2score = player2score + 1
            searvingPlayer = 1
            ball:reset()
            ball.dx = 100
            gameState = 'serve'
        end
        if ball.x >= VIRTUAL_WIDTH - 4 then
            searvingPlayer = 2
            player1score = player1score + 1
            ball:reset()
            ball.dx = -100
            gameState = 'serve'
        end 
    end

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
            gameState = 'serve'
        elseif gameState == 'serve' then
            gameState = 'play'
        end
    end
end


function love.draw()
    push:apply('start')

    love.graphics.clear(40 / 255, 45 / 255, 52 / 255, 255 / 255)

    ball:render()

    paddle1:render()
    paddle2:render()

    displayFPS()
    
    love.graphics.setFont(smallFont)

    if gameState == 'start' then
        love.graphics.printf("Welcome to Pong", 0, 20, VIRTUAL_WIDTH, 'center')
        love.graphics.printf("Press enter to play", 0, 32, VIRTUAL_WIDTH, 'center')
    elseif gameState == 'serve' then
        love.graphics.printf("Player " .. tostring(searvingPlayer) .. "'s turn!", 0, 20, VIRTUAL_WIDTH, 'center')
        love.graphics.printf("Press enter to searve", 0, 32, VIRTUAL_WIDTH, 'center')
    end
    
    love.graphics.setFont(scoreFont)
    love.graphics.print(player1score, VIRTUAL_WIDTH / 2 - 50, VIRTUAL_HEIGHT / 3)
    love.graphics.print(player2score, VIRTUAL_WIDTH / 2 + 30, VIRTUAL_HEIGHT / 3)

 
    push:apply('end')
end

function displayFPS()
    love.graphics.setColor(0, 1, 0, 1)
    love.graphics.setFont(smallFont)
    love.graphics.print('FPS: ' .. tostring(love.timer.getFPS()), 40, 20)
    love.graphics.setColor(1, 1, 1, 1)
end