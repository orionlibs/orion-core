package io.github.orionlibs.orion.core.data.structure.set;

import io.github.orionlibs.orion.core.abstraction.Orion;
import java.util.Set;

public class Sets extends Orion
{
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Set set)
    {
        return set != null && !set.isEmpty();
    }


    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(Set set)
    {
        return set == null || set.isEmpty();
    }
}