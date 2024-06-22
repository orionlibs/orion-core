package io.github.orionlibs.core.data.structure.list.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import java.util.Arrays;
import java.util.List;

public class DoListsSizesMatchTask<T> extends Orion
{
    @SuppressWarnings("unchecked")
    public static <T> boolean run(List<T>... lists)
    {

        if((lists != null && lists.length > 0))
        {
            return run(Arrays.asList(lists));
        }

        return true;
    }


    public static <T> boolean run(List<List<T>> lists)
    {

        if((lists != null && !lists.isEmpty()))
        {
            int listSize = lists.get(0).size();

            for(int i = 1; i < lists.size(); i++)
            {

                if(listSize != lists.get(i).size())
                {
                    return false;
                }

            }

        }

        return true;
    }
}