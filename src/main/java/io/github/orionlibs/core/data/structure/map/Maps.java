package io.github.orionlibs.core.data.structure.map;

import io.github.orionlibs.core.abstraction.Orion;
import java.util.Map;

public class Maps extends Orion
{
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Map map)
    {
        return map != null && !map.isEmpty();
    }


    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(Map map)
    {
        return map == null || map.isEmpty();
    }
}