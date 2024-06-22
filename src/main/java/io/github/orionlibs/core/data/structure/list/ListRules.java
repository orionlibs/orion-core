package io.github.orionlibs.core.data.structure.list;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import java.util.List;

public class ListRules extends Orion
{
    @SuppressWarnings("rawtypes")
    public static void notEmpty(List list)
    {
        Assert.notNull(list, "The given list cannot be null.");
    }
}