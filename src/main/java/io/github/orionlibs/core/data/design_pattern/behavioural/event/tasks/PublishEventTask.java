package io.github.orionlibs.core.data.design_pattern.behavioural.event.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.data.design_pattern.behavioural.event.AbstractEvent;
import io.github.orionlibs.core.data.design_pattern.behavioural.event.EventListenersRegistry;
import io.github.orionlibs.core.reflection.method.access.ReflectionMethodAccessService;
import io.github.orionlibs.core.runnable.OrionJob;

public class PublishEventTask extends Orion implements OrionJob
{
    private AbstractEvent event;


    public PublishEventTask(AbstractEvent event)
    {
        this.event = event;
    }


    @Override
    public void run()
    {
        EventListenersRegistry.getEventListenersForEvent((Class<? extends AbstractEvent>)event.getClass())
                        .forEach(eventListener -> ReflectionMethodAccessService.callMethod("processEvent", eventListener, new Class<?>[]
                        {AbstractEvent.class}, new Object[]
                        {(AbstractEvent)event}));
    }
}