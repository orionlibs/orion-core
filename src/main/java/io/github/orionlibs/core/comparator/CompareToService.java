package io.github.orionlibs.core.comparator;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.comparator.tasks.CompareToTask;

public class CompareToService<T> extends Orion
{
    public static <T> int compareTo(T x, T y)
    {
        return CompareToTask.run(x, y);
    }
}