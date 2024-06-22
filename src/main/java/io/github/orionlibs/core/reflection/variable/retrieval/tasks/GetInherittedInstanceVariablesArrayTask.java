package io.github.orionlibs.core.reflection.variable.retrieval.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetInherittedInstanceVariablesArrayTask extends Orion
{
    public static Field[] run(Class<?> aClass) throws SecurityException
    {
        Assert.notNull(aClass, "class input cannot be null.");
        List<Field> instanceVariables = new ArrayList<Field>();
        Class<?> superclass = aClass.getSuperclass();
        
        while(superclass != null)
        {
            instanceVariables.addAll(Arrays.asList(GetDeclaredInstanceVariablesArrayTask.run(superclass)));
            superclass = superclass.getSuperclass();
        }

        return instanceVariables.toArray(new Field[0]);
    }


    public static Field[] run(Object object) throws SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}