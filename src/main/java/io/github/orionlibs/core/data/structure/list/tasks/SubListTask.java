package io.github.orionlibs.core.data.structure.list.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.data.structure.list.OrionList;
import io.github.orionlibs.core.data.structure.list.type.OrionArrayList;
import java.util.stream.IntStream;

public class SubListTask<T> extends Orion
{
    public static <T> OrionList<T> run(OrionList<T> list, int startIndex, int endIndex)
    {

        if(list != null)
        {
            int sizeOfNewList = endIndex - startIndex + 1;
            OrionList<T> result = OrionArrayList.of(sizeOfNewList);
            IntStream.range(startIndex, endIndex + 1).forEach(i -> result.add(list.get(i)));
            return result;
        }

        return null;
    }
}