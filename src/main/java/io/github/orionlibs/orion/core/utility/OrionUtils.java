package io.github.orionlibs.orion.core.utility;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.exception.Assert;
import io.github.orionlibs.orion.core.reflection.object.ReflectionObjectsService;
import io.github.orionlibs.orion.core.utility.tasks.CloseResourceTask;
import java.io.Closeable;

public class OrionUtils extends Orion
{
    public static void closeResource(Closeable closeable)
    {
        CloseResourceTask.run(closeable);
    }


    public static int getBooleanAsInteger(boolean x)
    {
        return (x) ? 1 : 0;
    }


    public static int getBooleanAsInteger(Boolean x)
    {
        Assert.notNull(x, "The given Boolean object cannot be null.");
        return (x) ? 1 : 0;
    }


    public static <T> T copyFields(Object source, T target)
    {
        return ReflectionObjectsService.copyFields(source, target);
    }
}