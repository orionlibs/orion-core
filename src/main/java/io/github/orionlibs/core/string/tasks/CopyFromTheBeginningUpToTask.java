package io.github.orionlibs.core.string.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;

public class CopyFromTheBeginningUpToTask extends Orion
{
    public static String run(String stringToCopyFrom, int indexToCopyTo)
    {
        Assert.notEmpty(stringToCopyFrom, "The stringToCopyFrom input cannot be null/empty.");

        if(indexToCopyTo < stringToCopyFrom.length())
        {
            return new String(stringToCopyFrom.substring(0, indexToCopyTo + 1));
        }
        else
        {
            return "";
        }

    }
}