package io.magikcraft.t1;

import io.magikcraft.t1.command.HelloWorldCommandExecutor;
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
        this.getCommand("hw").setExecutor(new HelloWorldCommandExecutor());
    }

@Override
    public void onDisable(){}

}