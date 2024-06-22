package io.github.orionlibs.core.reflection.method.access.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import java.lang.reflect.Method;

public class MakeMethodAccessibleTask extends Orion
{
    public void run(Method method) throws SecurityException
    {
        Assert.notNull(method, "method input cannot be null.");
        method.setAccessible(true);
    }


    public void run(String method, Object objectMethodBelongsTo, Class<?>[] argumentTypes) throws SecurityException, NoSuchMethodException
    {
        Assert.notNull(method, "method input cannot be null.");
        objectMethodBelongsTo.getClass().getDeclaredMethod(method, argumentTypes).setAccessible(true);
    }
}