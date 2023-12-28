package io.github.orionlibs.orion.core.data.structure.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetIteratorAsListTask extends Orion
{
    public static <T> List<T> run(Iterator<T> iterator)
    {
        List<T> list = new ArrayList<>();

        if(iterator != null)
        {
            iterator.forEachRemaining(e -> list.add(e));
        }

        return list;
    }
}