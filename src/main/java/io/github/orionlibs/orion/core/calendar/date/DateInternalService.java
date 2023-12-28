package io.github.orionlibs.orion.core.calendar.date;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.calendar.CalendarService;
import io.github.orionlibs.orion.core.calendar.date.tasks.EqualsForDateTask;
import io.github.orionlibs.orion.core.calendar.date.tasks.HashCodeForDateTask;

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
        return CalendarService.formatDateTimeUnitWith2Characters(date.getMonth());
    }


    public static String formatDayWith2Characters(Date date)
    {
        return CalendarService.formatDateTimeUnitWith2Characters(date.getDay());
    }
}