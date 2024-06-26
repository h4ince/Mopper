package me.nortw.mopped.event;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class Event {
    public boolean cancelled;

    public Event call(){
        this.cancelled = false;
        call(this);
        return this;
    }

    private static void call(final Event event) {
        final List<Data> dataList = EventManager.get(event.getClass());

        if (dataList != null) {
            for (final Data data : dataList){
                try{
                    data.target().invoke(data.source(), event);
                }
                catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
