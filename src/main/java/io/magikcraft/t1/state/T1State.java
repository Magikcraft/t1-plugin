package io.magikcraft.t1.state;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import org.bukkit.Bukkit;
//import org.bukkit.Server;
//import org.bukkit.entity.Player;
//import org.bukkit.plugin.Plugin;
//import org.bukkit.plugin.PluginManager;
//import com.google.api.client.json.JsonFactory;
//import java.util.UUID;

public class T1State extends GenericJson{
    @Key("minecraft_player_name")
    private String minecraftPlayerName;

    @Key
    private double bgl;

    @Key
    private double insulin;

    public String getMinecraftPlayerName() {
        return minecraftPlayerName;
    }

    public void setMinecraftPlayerName(String minecraftPlayerName) {
        this.minecraftPlayerName = minecraftPlayerName;
    }

    public double getBgl() {
        return bgl;
    }

    public void setBgl(double bgl) {
        this.bgl = bgl;
    }

    public double getInsulin() {
        return insulin;
    }

    public void setInsulin(double insulin) {
        this.insulin = insulin;
    }

    public T1State() {
        this.minecraftPlayerName = null;
        this.bgl = 0.0;
        this.insulin = 0.0;
    }

    public T1State clone(){
        return (T1State) super.clone();
    }
}
