package io.github.orionlibs.orion.core.reflection.method.access;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.reflection.method.access.tasks.CallMethodTask;
import io.github.orionlibs.orion.core.reflection.method.access.tasks.MakeMethodAccessibleTask;
import java.lang.reflect.Method;

public class ReflectionMethodAccessService extends OrionService
{
    public static void makeMethodAccessible(Method method)
    {
        new MakeMethodAccessibleTask().run(method);
    }


    public static Object callMethod(Method method, Object objectMethodBelongsTo, Object[] methodArguments)
    {
        return new CallMethodTask().run(method, objectMethodBelongsTo, methodArguments);
    }


    public static Object callMethod(String method, Object objectMethodBelongsTo, Object[] methodArguments)
    {
        return new CallMethodTask().run(method, objectMethodBelongsTo, methodArguments);
    }


    public static Object callMethod(String method, Object objectMethodBelongsTo, Class<?>[] argumentTypes, Object[] methodArguments)
    {
        return new CallMethodTask().run(method, objectMethodBelongsTo, argumentTypes, methodArguments);
    }


    public static Object callMethod(String method, Object objectMethodBelongsTo)
    {
        return new CallMethodTask().run(method, objectMethodBelongsTo);
    }
}