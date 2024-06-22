package io.github.orionlibs.core.comparator.tasks;

import io.github.orionlibs.core.abstraction.Orion;

public class CompareToTask<T> extends Orion
{
    @SuppressWarnings("unchecked")
    public static <T> int run(T x, T y)
    {

        if(x == null || y == null || x instanceof Comparable == false || y instanceof Comparable == false)
        {
            return 0;
        }
        else
        {
            return ((Comparable<T>)x).compareTo(y);
        }

    }
}