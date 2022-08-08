package de.linux3000.listener;

import de.linux3000.events.IEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BaseEventManager implements IEventManager{



        private List<EventListener> listeners = new ArrayList<>();

        public void registerListener(EventListener listener) {
            listeners.add(listener);
        }

        public void removeListener(EventListener listener) {
            listeners.remove(listener);
        }

        public void callEvent(IEvent event) {

            for(EventListener listener : this.listeners) {
                Class<? extends EventListener> listenerClass = listener.getClass();
                for(Method method : listenerClass.getMethods()) {
                    Class<?>[] parameter = method.getParameterTypes();
                    if(parameter.length == 1) {
                        if(parameter[0] == event.getClass()) {
                            try {
                                method.invoke(listener, event);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }



    }


