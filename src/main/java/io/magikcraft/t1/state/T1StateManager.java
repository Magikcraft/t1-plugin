package io.magikcraft.t1.state;

import io.magikcraft.t1.T1Player;
import org.apache.http.MethodNotSupportedException;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class T1StateManager {

    private final HashMap<Player, T1Player> playerT1StateMap;
    private final Configuration config;

    // We need configuration otherwise it doesn't make sense to initialise
    // the class
    private T1StateManager(){
        playerT1StateMap = null;
        config = null;
    }

    /**
     * Configuration for default mechanics constants
     * @param config
     */
    public T1StateManager(Configuration config){
        playerT1StateMap = new HashMap<>();
        this.config = config;
    }

    /**
     *
     * @return a copy of the player state
     * this will initialise a new player state if one does not exist
     */
    public T1Player getT1State(Player player){

        T1Player t1PlayerToReturn = playerT1StateMap.get(player);

        // If there is not t1Player for this player yet we need to create it
        if(null == t1PlayerToReturn){
            t1PlayerToReturn = new T1Player(player);
            playerT1StateMap.put(player, t1PlayerToReturn);
        }

        return t1PlayerToReturn;
    }

    // this should have relatively smooth intervals. if there is too much wierdness like
    // effects will will need to put a delta value and apply that. But in theory there is already
    // a delta in the game loop.

    public void update(){
        for(T1Player t1Player: playerT1StateMap.values()){
            t1Player.update();
        }
    }



}
