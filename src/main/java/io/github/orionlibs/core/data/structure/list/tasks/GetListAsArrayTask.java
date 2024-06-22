package io.github.orionlibs.core.data.structure.list.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.data.structure.list.ListRules;
import io.github.orionlibs.core.data.structure.list.OrionList;
import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class GetListAsArrayTask<T> extends Orion
{
    @SuppressWarnings("unchecked")
    public static <T> T[] run(OrionList<T> list)
    {
        ListRules.notEmpty(list);
        T[] array = (T[])Array.newInstance(list.getDataType(), list.size());

        if(list.isNotEmpty())
        {
            IntStream.range(0, list.size()).forEach(i -> array[i] = list.get(i));
        }

        return array;
    }
}