package io.magikcraft.t1;

import io.magikcraft.t1.command.EatCommandExecutor;
import io.magikcraft.t1.command.TakeCommandExecutor;
import io.magikcraft.t1.state.T1StateManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;


public class T1 extends JavaPlugin {
    private T1StateManager stateManager;
    private BukkitRunnable t1StateUpdateScheduler;
    @Override
    public void onEnable() {
        stateManager = new T1StateManager(null);

        getCommand("eat").setExecutor(new EatCommandExecutor(stateManager));
        getCommand("take").setExecutor(new TakeCommandExecutor(stateManager));

        t1StateUpdateScheduler = new BukkitRunnable() {
            @Override
            public void run() {
                stateManager.update();
            }
        };
        
        t1StateUpdateScheduler.runTaskTimer(this,1, 300);
    }

    @Override
    public void onDisable(){
        t1StateUpdateScheduler.cancel();
    }

}