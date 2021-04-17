Class = require 'class'

require 'Map'
require 'Player'

-- actual window resolution
WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 720

love.graphics.setDefaultFilter('nearest', 'nearest')

-- initialises the map
map = Map()
-- initialises the player
player = Player()
seconds = 0
route = false
continue = true


function love.load()
    -- sets up the screen
    love.window.setMode(WINDOW_WIDTH, WINDOW_HEIGHT, {resizable=true, vsync=false, minwidth=400, minheight=300})

	-- sets up a different, better-looking font as our default
    love.graphics.setFont(love.graphics.newFont('fonts/font.ttf', 25))
    
    -- sets the window title
    love.window.setTitle('Maze')
    
end

function love.update(dt) 
    -- checks if it has reached the end of the map and restarts if it has
    if player.restart == true then
        -- resets the map
        map = Map() 
        map:render()
        map:setRoute(false)
        player = Player()
        -- makes sure the player stops restarting
        player.restart = false
        -- resets the time
        seconds = 0
    end
    -- updates the player
    if route == false then
        player:update(map, dt, true)
    else
        player:update(map, dt, false)
    end

    -- if the player is playing 
    if player.state == 'playing' and player:isOnStart(player.x, player.y) == false and route == false then
        -- adds the time since it was last updated to the time passed 
        seconds = seconds + dt
    end

    if (seconds >= 30) then
        player.state = 'end'
    end
end

function love.draw()
    -- begin virtual resolution drawing
    love.graphics.clear(0/255, 0/255, 0/255, 0/255)
    -- renders the map and player
    map:render()    
    -- renders the player
    player:render()
    -- loads the player state
    player:load()
    -- loads the map state
    map:load()
    
    -- formats and prints minutes and seconds
    if (math.floor(seconds, 0.001) >= 60) then
        love.graphics.printf("time = " .. math.floor(seconds / 60) .. "m " .. math.fmod(math.floor(seconds, 0.001), 60) .. "s", 0, 50, WINDOW_WIDTH, 'left')
    -- formats seconds only
    elseif (math.floor(seconds, 0.001) < 60) then
        love.graphics.printf("time = " .. math.floor(seconds, 0.001) .. "s", 0, 50, WINDOW_WIDTH, 'left')
    end
    love.graphics.printf("Your score = " .. math.floor((seconds /  player:getCount()) * 1000), 0, 10, WINDOW_WIDTH, 'left')
    if player.state == 'end' then
        love.graphics.printf('Your score is ' .. math.floor((seconds /  player:getCount()) * 1000), 0, 30, WINDOW_WIDTH, 'center')
    end
end

-- called whenever a key is pressed
function love.keypressed(key)
    -- exits the game
    if key == 'escape' then
        love.event.quit()
    -- moves right
    elseif key == 'right' and player:collides(map, player.x + 1, player.y) then
        player.x = player.x + 1
    -- moves left
    elseif key == 'left' and player:collides(map, player.x - 1, player.y) then
        player.x = player.x - 1
    -- moves up
    elseif key == 'up' and player:collides(map, player.x, player.y - 1) then
        player.y = player.y - 1
    -- moves down
    elseif key == 'down' and player:collides(map, player.x, player.y + 1) then
        player.y = player.y + 1
    -- shows the answers to the map
    elseif key == 's' then
        if route == false then
            route = true
            seconds = 0
        else
            route = false
            love.graphics.printf('The game will restart once you press s or complete the maze', 0, 50, WINDOW_WIDTH, 'center')
            map = Map()
            player = Player()
        end
        map:setRoute(route)
        if map:getAbsoluteTile(player.x, player.y) == 2 then
            -- player.x = map:playerOnXAxis(player.y)
            player.y = map:playerOnYAxis(player.x)
        end
    end
    -- renders the player
    player:render()
end