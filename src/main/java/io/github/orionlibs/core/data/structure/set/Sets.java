package io.github.orionlibs.core.data.structure.set;

import io.github.orionlibs.core.abstraction.Orion;
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