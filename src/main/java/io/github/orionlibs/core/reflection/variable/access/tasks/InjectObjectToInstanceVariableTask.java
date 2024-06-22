package io.github.orionlibs.core.reflection.variable.access.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.InaccessibleException;
import java.lang.reflect.Field;

public class InjectObjectToInstanceVariableTask extends Orion
{
    public void run(Object object, Object objectToInject, Field instanceVariable) throws InaccessibleException
    {

        try
        {
            instanceVariable.set(object, objectToInject);
        }
        catch(IllegalArgumentException e)
        {
            throw e;
        }
        catch(IllegalAccessException e)
        {
            throw new InaccessibleException("The instance variable is inaccessible.");
        }

    }
}