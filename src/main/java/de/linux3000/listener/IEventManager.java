package de.linux3000.listener;

import de.linux3000.events.IEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public interface IEventManager {



    void registerListener(EventListener listener);

    void removeListener(EventListener listener);
    void callEvent(IEvent event) ;


}
