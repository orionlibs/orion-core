package io.github.orionlibs.orion.core.data.design_pattern.behavioural.event;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.data.design_pattern.behavioural.event.tasks.PublishEventTask;
import io.github.orionlibs.orion.core.runnable.OrionJobService;

public class EventService extends OrionService
{
    public static void registerEventListener(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener)
    {
        EventListenersRegistry.registerEventListener(eventClass, eventListener);
    }


    public static void deregisterEventListener(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener)
    {
        EventListenersRegistry.deregisterEventListener(eventClass, eventListener);
    }


    public static void publishEventSynchronously(AbstractEvent event)
    {
        new PublishEventTask(event).run();
    }


    public static void publishEventAsynchronously(AbstractEvent event)
    {
        OrionJobService.runJobWithCurrentThreadName(new PublishEventTask(event));
        return;
    }
}