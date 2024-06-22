package io.github.orionlibs.core.reflection.method.retrieval.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.stream.OrionStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

public class GetDeclaredMethodsArrayTask extends Orion
{
    public static Method[] run(Class<?> aClass)
    {
        Assert.notNull(aClass, "aClass input cannot be null.");
        Method[] methods = aClass.getDeclaredMethods();
        Stream<Method> stream = Arrays.stream(methods)
                        .filter(method -> !Modifier.isStatic(method.getModifiers()));
        return OrionStream.getAsArray(stream, Method.class);
    }


    public static Method[] run(Object object)
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}