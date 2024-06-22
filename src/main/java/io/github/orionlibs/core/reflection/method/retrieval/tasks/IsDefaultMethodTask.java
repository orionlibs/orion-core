package io.github.orionlibs.core.reflection.method.retrieval.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class IsDefaultMethodTask extends Orion
{
    public static boolean run(Method method)
    {
        Assert.notNull(method, "method input cannot be null.");
        return !Modifier.isPrivate(method.getModifiers())
                        && !Modifier.isProtected(method.getModifiers())
                        && !Modifier.isPublic(method.getModifiers());
    }
}