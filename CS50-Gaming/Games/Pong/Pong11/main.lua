WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 720

VIRTUAL_WIDTH = 432
VIRTUAL_HEIGHT = 243

smallFont = love.graphics.newFont('04B_03__.TTF', 8)
scoreFont = love.graphics.newFont('04B_03__.TTF', 32)
victoryFont = love.graphics.newFont('04B_03__.TTF', 24)

player1score = 0
player2score = 0

PADDLE_SPEED = 200

searvingPlayer = math.random(2) == 1 and 1 or 2   

winningPlayer = 0

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

    sounds = {
        ['paddle_hit'] = love.audio.newSource('paddle_hit.wav', 'static'),
        ['point_scored'] = love.audio.newSource('point_scored.wav', 'static'),
        ['wall_hit'] = love.audio.newSource('wall_hit.wav', 'static')
    }

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
            ball.dx = -ball.dx * 1.03
            ball.x = paddle1.x + 5
            sounds["paddle_hit"]:play()
        end

        if ball:collides(paddle2) then
            ball.dx = -ball.dx * 1.03
            ball.x = paddle2.x - 4
            sounds["paddle_hit"]:play()
        end

        if ball.y <= 0 then
            ball.dy = -ball.dy
            ball.y = 0
            sounds['wall_hit']:play()
        end

        if ball.y >= VIRTUAL_HEIGHT - 4 then
            ball.dy = -ball.dy
            ball.y = VIRTUAL_HEIGHT - 4
            sounds['wall_hit']:play()
        end

        if ball.x <= 0 then
            player2score = player2score + 1

            sounds['point_scored']:play()
            searvingPlayer = 1
            ball:reset()
            ball.dx = 100
            if player2score >= 10 then
                gameState = 'victory'
                winningPlayer = 2
            else
                gameState = 'serve'
            end
        end
        if ball.x >= VIRTUAL_WIDTH - 4 then
            searvingPlayer = 2
            player1score = player1score + 1
            sounds['point_scored']:play()
            ball:reset()
            ball.dx = -100
            if player1score >= 10 then
                gameState = 'victory'
                winningPlayer = 1
            else
                gameState = 'serve'
            end
        end 
    end

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

    paddle1:update(dt)
    paddle2:update(dt)
end

function love.keypressed(key)
    if key == 'escape' then
        love.event.quit()
    elseif key == 'enter' or key == 'return' then
        if gameState == 'start' then
            gameState = 'serve'
        elseif gameState == 'victory' then
            gameState = 'start'
            player1score = 0
            player2score = 0
        elseif gameState == 'serve' then
            gameState = 'play'
        end
    end
end

-- Syntax error: main.lua:127: 'then' expected near '='

function love.draw()
    push:apply('start')

    love.graphics.clear(40 / 255, 45 / 255, 52 / 255, 255 / 255)

    ball:render()

    paddle1:render()
    paddle2:render()

    displayFPS()

    if gameState == 'start' then
        love.graphics.setFont(smallFont)
        love.graphics.printf("Welcome to Pong", 0, 20, VIRTUAL_WIDTH, 'center')
        love.graphics.printf("Press enter to play", 0, 32, VIRTUAL_WIDTH, 'center')
    elseif gameState == 'serve' then
        love.graphics.setFont(smallFont)
        love.graphics.printf("Player " .. tostring(searvingPlayer) .. "'s turn!", 0, 20, VIRTUAL_WIDTH, 'center')
        love.graphics.printf("Press enter to searve", 0, 32, VIRTUAL_WIDTH, 'center')
    elseif gameState == 'victory' then
        love.graphics.setFont(victoryFont)
        love.graphics.printf("Player " .. tostring(winningPlayer) .. " wins", 0, 10, VIRTUAL_WIDTH, 'center')
        love.graphics.setFont(smallFont)
        love.graphics.printf("Press enter to serve", 0, 42, VIRTUAL_WIDTH, 'center')
    elseif gameState == 'play' then
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