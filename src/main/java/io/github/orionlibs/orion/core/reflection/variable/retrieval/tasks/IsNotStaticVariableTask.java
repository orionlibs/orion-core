package io.github.orionlibs.orion.core.reflection.variable.retrieval.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.exception.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class IsNotStaticVariableTask extends Orion
{
    public static boolean run(Field variable)
    {
        Assert.notNull(variable, "The given variable input cannot be null.");
        return !Modifier.isStatic(variable.getModifiers());
    }
}