package io.github.orionlibs.orion.core.comparator;

import io.github.orionlibs.orion.core.abstraction.Orion;
import java.util.Comparator;

public class ReverseElementComparator<T> extends Orion implements Comparator<T>
{
    @Override
    public int compare(T x, T y)
    {
        return new ReverseCompareToService<T>().compareTo(x, y);
    }
}