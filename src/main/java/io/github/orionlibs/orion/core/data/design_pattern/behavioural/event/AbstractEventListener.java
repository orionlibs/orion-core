package io.github.orionlibs.orion.core.data.design_pattern.behavioural.event;

import io.github.orionlibs.orion.core.abstraction.OrionInterface;

public interface AbstractEventListener extends OrionInterface
{
    public void processEvent(AbstractEvent event);
}