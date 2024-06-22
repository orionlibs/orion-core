package io.github.orionlibs.core.data.design_pattern.behavioural.event.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.data.design_pattern.behavioural.event.AbstractEvent;
import io.github.orionlibs.core.data.design_pattern.behavioural.event.AbstractEventListener;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class RegisterEventListenerTask extends Orion
{
    public static void run(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener, ConcurrentMap<Class<? extends AbstractEvent>, CopyOnWriteArrayList<AbstractEventListener>> eventClassToEventListenersMapper)
    {

        if(eventClassToEventListenersMapper.get(eventClass) != null)
        {
            eventClassToEventListenersMapper.get(eventClass).add(eventListener);
        }
        else
        {
            CopyOnWriteArrayList<AbstractEventListener> eventListeners = new CopyOnWriteArrayList<>();
            eventListeners.add(eventListener);
            eventClassToEventListenersMapper.put(eventClass, eventListeners);
        }

    }
}