package io.github.orionlibs.orion.core.reflection.object.equality;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.reflection.object.equality.tasks.AreObjectsEqualTask;

public class ObjectsEqualityService extends OrionService
{
    public static boolean areObjectsEqual(Object object1, Object object2, Object... moreObjects)
    {
        return AreObjectsEqualTask.run(object1, object2, moreObjects);
    }
}