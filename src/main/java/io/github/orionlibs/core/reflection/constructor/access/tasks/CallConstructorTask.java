package io.github.orionlibs.core.reflection.constructor.access.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CallConstructorTask extends Orion
{
    public static Object run(Constructor<?> constructor, Object... methodArguments) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
    {
        Assert.notNull(constructor, "constructor input cannot be null.");
        return constructor.newInstance(methodArguments);
    }
}