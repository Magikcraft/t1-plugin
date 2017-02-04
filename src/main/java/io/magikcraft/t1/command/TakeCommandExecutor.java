package io.magikcraft.t1.command;

import io.magikcraft.t1.state.T1StateManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by forward on 1/27/17.
 */
public class TakeCommandExecutor implements CommandExecutor {

    private T1StateManager stateManager;

    public TakeCommandExecutor(T1StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("take") && commandSender instanceof Player){

            commandSender.sendMessage("Do the injectings (1 unit)");
            stateManager.getT1State((Player) commandSender).takeInsulin(1.0);

            return true;
        }

        return false;
    }
}
