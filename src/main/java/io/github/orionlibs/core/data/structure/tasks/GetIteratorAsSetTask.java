package io.github.orionlibs.core.data.structure.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GetIteratorAsSetTask extends Orion
{
    public static <T> Set<T> run(Iterator<T> iterator)
    {
        Set<T> set = new HashSet<>();

        if(iterator != null)
        {
            iterator.forEachRemaining(e -> set.add(e));
        }

        return set;
    }
}