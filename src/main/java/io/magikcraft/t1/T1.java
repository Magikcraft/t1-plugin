package io.magikcraft.t1;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class T1 extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        this.getCommand("hw").setExecutor(new HelloWorldCommandExecutor());
    }

    @Override
    public void onDisable(){}

}
