package io.github.orionlibs.orion.core.reflection.method.access.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.exception.Assert;
import java.lang.reflect.Method;

public class MakeMethodAccessibleTask extends Orion
{
    public void run(Method method) throws SecurityException
    {
        Assert.notNull(method, "method input cannot be null.");
        method.setAccessible(true);
    }
}