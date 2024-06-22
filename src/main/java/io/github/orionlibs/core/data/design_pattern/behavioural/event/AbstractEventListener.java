package io.github.orionlibs.core.data.design_pattern.behavioural.event;

import io.github.orionlibs.core.abstraction.OrionInterface;

public interface AbstractEventListener extends OrionInterface
{
    public void processEvent(AbstractEvent event);
}