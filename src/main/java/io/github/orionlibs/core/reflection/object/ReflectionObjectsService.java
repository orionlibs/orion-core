package io.github.orionlibs.core.reflection.object;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.exception.InaccessibleException;
import io.github.orionlibs.core.reflection.object.tasks.AreObjectsNotNullTask;
import io.github.orionlibs.core.reflection.object.tasks.AreObjectsNullTask;
import io.github.orionlibs.core.reflection.variable.access.ReflectionInstanceVariablesAccessService;
import io.github.orionlibs.core.reflection.variable.retrieval.ReflectionInstanceVariablesRetrievalService;
import java.lang.reflect.Field;
import java.util.List;

public class ReflectionObjectsService extends OrionService
{
    public static boolean isObjectNull(Object object)
    {
        return object == null;
    }


    public static boolean isObjectNotNull(Object object)
    {
        return object != null;
    }


    public static boolean areObjectsNull(Object... objects)
    {
        return AreObjectsNullTask.run(objects);
    }


    public static boolean areObjectsNotNull(Object... objects)
    {
        return AreObjectsNotNullTask.run(objects);
    }


    public static <T> T copyFields(Object source, T target)
    {
        Assert.notNull(source, "source input cannot be null.");
        Assert.notNull(target, "target input cannot be null.");
        List<Field> fieldsToCopy = ReflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(source);
        List<Field> targetFields = ReflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(target);

        if(fieldsToCopy != null)
        {

            for(Field field : fieldsToCopy)
            {
                ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(field);

                for(Field targetField : targetFields)
                {

                    if(field.getName().equals(targetField.getName()))
                    {
                        ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(targetField);

                        try
                        {
                            ReflectionInstanceVariablesAccessService.injectObjectToInstanceVariable(target, field.get(source), targetField);
                        }
                        catch(InaccessibleException | IllegalArgumentException | IllegalAccessException exception)
                        {
                            exception.printStackTrace();
                        }

                        break;
                    }

                }

            }

        }

        return target;
    }
}