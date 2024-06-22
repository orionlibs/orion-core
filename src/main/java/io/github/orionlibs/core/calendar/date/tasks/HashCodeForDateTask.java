package io.github.orionlibs.core.calendar.date.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.date.Date;
import io.github.orionlibs.core.calendar.date.DateRules;

public class HashCodeForDateTask extends Orion
{
    public static int run(Date date)
    {
        DateRules.isValid(date);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + date.getYear();
        hash = defaultPrimeNumberForHashing * hash + date.getMonth();
        return defaultPrimeNumberForHashing * hash + date.getDay();
    }
}