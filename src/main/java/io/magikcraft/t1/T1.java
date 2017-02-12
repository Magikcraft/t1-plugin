package io.magikcraft.t1;

import io.magikcraft.t1.command.MCT1CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class
T1 extends JavaPlugin
{
@Override
    public void onEnable()
    {
        this.getCommand("t1").setExecutor(new MCT1CommandExecutor());
    }

@Override
    public void onDisable(){}

}