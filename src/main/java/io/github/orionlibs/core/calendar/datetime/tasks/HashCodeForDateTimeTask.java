package io.github.orionlibs.core.calendar.datetime.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.datetime.DateTime;
import io.github.orionlibs.core.calendar.datetime.DateTimeRules;

public class HashCodeForDateTimeTask extends Orion
{
    public static int run(DateTime dateTime)
    {
        DateTimeRules.isValid(dateTime);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + dateTime.getDate().hashCode();
        hash = defaultPrimeNumberForHashing * hash + dateTime.getTime().hashCode();
        return defaultPrimeNumberForHashing * hash + dateTime.getZoneID().hashCode();
    }
}