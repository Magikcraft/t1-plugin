package io.magikcraft.t1.listener;

import com.sun.deploy.net.BasicHttpRequest;
import com.sun.deploy.net.HttpRequest;
import io.magikcraft.t1.state.T1StateChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import sun.plugin.navig.motif.Plugin;

import java.io.IOException;
import java.util.logging.Logger;


public class T1StateChangeListener implements Listener {

    private Logger logger;

    public T1StateChangeListener (){
        this.logger = Bukkit.getLogger();
    }
    public T1StateChangeListener(Logger logger){
        this.logger = logger;
    }

    @EventHandler
    public void onT1StateChangeEvent(T1StateChangeEvent stateChangeEvent){
        logger.info("State change event listener triggered");
        try {
            logger.info(stateChangeEvent.getState().toPrettyString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
