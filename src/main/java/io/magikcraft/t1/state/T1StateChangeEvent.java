package io.magikcraft.t1.state;

import com.google.gson.JsonObject;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class T1StateChangeEvent extends Event{

    private JsonObject before;
    private T1State state;

    public T1StateChangeEvent(JsonObject before, T1State state){
        this.before = before;
        this.state = state;
    }

    public JsonObject getBefore() {
        return this.before;
    }

    public T1State getState(){
        return this.state;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
