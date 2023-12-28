package io.github.orionlibs.orion.core.comparator;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.comparator.tasks.ReverseCompareToTask;

public class ReverseCompareToService<T> extends Orion
{
    public int compareTo(T x, T y)
    {
        return ReverseCompareToTask.run(x, y);
    }
}