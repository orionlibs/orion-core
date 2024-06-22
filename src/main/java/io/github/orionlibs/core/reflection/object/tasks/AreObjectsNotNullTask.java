package io.github.orionlibs.core.reflection.object.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import java.util.Arrays;

public class AreObjectsNotNullTask extends Orion
{
    public static boolean run(Object... objects)
    {

        if(objects != null && objects.length > 0)
        {
            return !Arrays.stream(objects).anyMatch(object -> object == null);
        }

        return false;
    }
}