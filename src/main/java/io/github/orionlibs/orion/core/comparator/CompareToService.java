package io.github.orionlibs.orion.core.comparator;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.comparator.tasks.CompareToTask;

public class CompareToService<T> extends Orion
{
    public static <T> int compareTo(T x, T y)
    {
        return CompareToTask.run(x, y);
    }
}