package io.github.orionlibs.orion.core.string.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import java.util.List;

public class DoesStringEndWithAnyTask extends Orion
{
    public static boolean run(String s, List<String> stringsToCheck)
    {

        for(String stringToCheck : stringsToCheck)
        {

            if(s.endsWith(stringToCheck))
            {
                return true;
            }

        }

        return false;
    }
}