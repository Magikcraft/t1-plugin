package io.magikcraft.t1.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloWorldCommandExecutor implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if( sender instanceof Player)
        {
            sender.sendMessage("Hello mortal");
        }
        else {
            sender.sendMessage("Hello diety");
        }
        return true;
    }
}
