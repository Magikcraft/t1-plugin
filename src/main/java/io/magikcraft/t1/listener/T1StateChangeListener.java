package io.magikcraft.t1.listener;

import io.magikcraft.t1.state.T1StateChangeEvent;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import sun.plugin.navig.motif.Plugin;

import java.util.logging.Logger;


public class T1StateChangeListener implements Listener {

    Logger logger;
    public T1StateChangeListener(Logger logger){
        this.logger = logger;
    }

    @EventHandler
    public void onT1StateChangeEvent(T1StateChangeEvent stateChangeEvent){
        logger.info("T1 State Change");
        logger.info("From: " + stateChangeEvent.getBefore().getAsString());
        logger.info("To: " + stateChangeEvent.getState().toJSON().getAsString());
    }
}
