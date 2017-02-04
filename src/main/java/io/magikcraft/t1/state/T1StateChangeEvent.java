package io.magikcraft.t1.state;

import com.google.gson.JsonObject;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class T1StateChangeEvent extends Event{

    private T1State state;

    public T1StateChangeEvent(T1State after){
        this.state = state;
    }

    public T1State getState(){
        return this.state;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
