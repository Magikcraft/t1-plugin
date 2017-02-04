package io.magikcraft.t1.command;

import io.magikcraft.t1.state.T1StateManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by forward on 1/27/17.
 */
public class EatCommandExecutor implements CommandExecutor {

    private T1StateManager stateManager;

    public EatCommandExecutor(T1StateManager stateManager){
        this.stateManager = stateManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("eat") || commandSender instanceof Player) {
            commandSender.sendMessage("doing the eats (1 unit)");
            stateManager.getT1State((Player) commandSender).eatFood(1.0);
            return true;
        }

        return false;
    }
}
