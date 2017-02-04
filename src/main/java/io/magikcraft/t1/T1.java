package io.magikcraft.t1;

import io.magikcraft.t1.command.EatCommandExecutor;
import io.magikcraft.t1.command.TakeCommandExecutor;
import io.magikcraft.t1.state.T1StateManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class T1 extends JavaPlugin {
    private T1StateManager stateManager;

    @Override
    public void onEnable() {
        stateManager = new T1StateManager(null);

        getCommand("eat").setExecutor(new EatCommandExecutor(stateManager));
        getCommand("take").setExecutor(new TakeCommandExecutor(stateManager));
    }

    @Override
    public void onDisable(){}

}