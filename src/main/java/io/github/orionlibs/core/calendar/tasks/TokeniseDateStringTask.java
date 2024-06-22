package io.github.orionlibs.core.calendar.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.date.DateRules;
import io.github.orionlibs.core.calendar.date.InvalidDateException;

public class TokeniseDateStringTask extends Orion
{
    public static String[] run(String date) throws InvalidDateException
    {
        DateRules.isValid(date);

        if(date.indexOf("-") >= 0)
        {
            return date.split("-");
        }
        else if(date.indexOf("/") >= 0)
        {
            return date.split("/");
        }
        else
        {
            return null;
        }

    }
}