package io.magikcraft.t1.state;

import com.google.gson.JsonObject;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class T1State
{

    private Player minecraftPlayer;
    private Server minecraftServer;
    private Plugin plugin;

    private BGLType bgl;

    private double insulinUnitsOnBoard;
    private double carbsOnBoard;

    private double carbsPerUnit;


    public T1State(JsonObject jsonObject, Server minecraftServer, Plugin plugin)
    {
        if (null != jsonObject.get("t1PlayerName") || null != jsonObject.get("t1PlayerUUID") ) {
            this.bgl = jsonObject.get("bgl").getAsDouble();
            this.minecraftServer = minecraftServer;
            this.plugin = plugin;

        }
    }

    public T1State(Player minecraftPlayer)
    {
        this.minecraftPlayer = minecraftPlayer;

        this.bgl = new BGLType(6, mmolL);

        this.insulinUnitsOnBoard = 0.0;
        this.carbsOnBoard = 0.0;
        this.carbsPerUnit = 15.0;

    }

    public void setBgl(double bgl)
    {
        JsonObject before = this.toJSON();
        this.blg.setBGL(bgl);
        minecraftServer.getPluginManager().callEvent(new T1StateChangeEvent(before,this));
    }




    public JsonObject toJSON()
    {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("t1PlayerName", minecraftPlayer.getName());
        jsonObject.addProperty("t1PlayerUUID", minecraftPlayer.getUniqueId().toString());
        jsonObject.addProperty("bgl", bgl);
        jsonObject.addProperty("insulin", insulin);

        return jsonObject;
    }

}
