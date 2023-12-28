package io.github.orionlibs.orion.core.calendar.datetime;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.calendar.datetime.tasks.EqualsForDateTimeTask;
import io.github.orionlibs.orion.core.calendar.datetime.tasks.HashCodeForDateTimeTask;

class DateTimeInternalService extends OrionService
{
    public static int hashCode(DateTime dateTime)
    {
        return HashCodeForDateTimeTask.run(dateTime);
    }


    public static boolean equals(DateTime dateTime, Object other)
    {
        return EqualsForDateTimeTask.run(dateTime, other);
    }
}