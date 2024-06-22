package io.github.orionlibs.core.reflection.constructor.access;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.reflection.constructor.access.tasks.CallConstructorTask;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionConstructorAccessService extends OrionService
{
    public static Object callConstructor(Constructor<?> constructor, Object... constructorArguments) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
    {
        return CallConstructorTask.run(constructor, constructorArguments);
    }
}