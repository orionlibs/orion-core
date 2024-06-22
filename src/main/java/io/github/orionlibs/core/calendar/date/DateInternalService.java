package io.github.orionlibs.core.calendar.date;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.calendar.date.tasks.EqualsForDateTask;
import io.github.orionlibs.core.calendar.date.tasks.HashCodeForDateTask;
import io.github.orionlibs.core.string.StringsService;

class DateInternalService extends OrionService
{
    public static int hashCode(Date date)
    {
        return HashCodeForDateTask.run(date);
    }


    public static boolean equals(Date date, Object other)
    {
        return EqualsForDateTask.run(date, other);
    }


    public static String formatMonthWith2Characters(Date date)
    {
        return StringsService.formatWith2Characters(date.getMonth());
    }


    public static String formatDayWith2Characters(Date date)
    {
        return StringsService.formatWith2Characters(date.getDay());
    }
}