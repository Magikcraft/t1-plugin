package io.magikcraft.t1;

import com.sun.istack.internal.NotNull;
import io.magikcraft.t1.state.T1State;
import io.magikcraft.t1.state.T1StateChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class T1Player {

    private final Player player;
    private final T1State t1State;
    private final PluginManager pluginManager;
    private double foodValueInGut;

    /**
     * No args constructor does not make sense for this class. disable it by making it private
     */
    private T1Player(){
        player = null;
        t1State = null;
        pluginManager = null;
        foodValueInGut = 0.0;
    }

    /**
     * Plain constructor using completely pre-supplied data
     * @param player
     * @param t1State
     */
    public T1Player(@NotNull Player player, @NotNull T1State t1State) {
        this.player = player;
        this.t1State = t1State;
        pluginManager = Bukkit.getPluginManager();
        foodValueInGut = 0.0;
    }

    /**
     * Constructs a new T1State from the player given to produce composite
     * T1Player
     *
     * @param player
     */
    public T1Player(@NotNull Player player){
        this.player = player;
        this.t1State = new T1State();
        this.t1State.setMinecraftPlayerName(this.player.getName());
        this.pluginManager = Bukkit.getPluginManager();
        foodValueInGut = 0.0;
    }

    // To facilitate the loading from config of some sort eventually

    /**
     * Uses the player name in t1State to find the relevant player. To facilitate
     * the eventual development of persistent storage of player.
     * @param t1State
     */
    public T1Player(@NotNull T1State t1State){
        this.pluginManager = Bukkit.getPluginManager();
        foodValueInGut = 0.0;
        if(t1State.getMinecraftPlayerName() != null) {
            this.t1State = t1State;

            this.player = Bukkit.getPlayer(t1State.getMinecraftPlayerName());
        } else {
            Bukkit.getLogger().warning("Could not find player");
            this.t1State = null;
            this.player = null;
        }
    }

    /**
     * Put food into the T1Players gut
     * @param foodValue
     */
    public void eatFood(double foodValue){
        foodValueInGut += foodValue;
    }

    /**
     * Put insulin into the T1Player's system
     * @param insulinValue
     */
    public void takeInsulin(double insulinValue){
        T1State before = t1State.clone();
        t1State.setInsulin(t1State.getInsulin() + insulinValue);
        pluginManager.callEvent(new T1StateChangeEvent(t1State.clone()));
    }


    private void digestFood(){
        // reduce food value in gut by x amount
        // increase blood glucose by x
        Bukkit.getLogger().info("digesting food");

    }

    private void absorbBloodGlucose(){
        // reduce insulin
        // reduce blood glucose
        // increase health (or hunger status )
        Bukkit.getLogger().info("absorbing blood glucose");
    }

    private void diseaseConditions(){
        // depending on state statistics
        // there is a chance of side effects
        Bukkit.getLogger().info("running gauntlet of disease side effects");
    }

    /**
     * Update the state based on our simplified diabetic model.
     */
    public void update(){
        digestFood();
        absorbBloodGlucose();
        diseaseConditions();

        pluginManager.callEvent(new T1StateChangeEvent( t1State.clone()));
    }
}
