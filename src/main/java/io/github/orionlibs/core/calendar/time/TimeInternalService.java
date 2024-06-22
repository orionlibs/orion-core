package io.github.orionlibs.core.calendar.time;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.calendar.time.tasks.EqualsForTimeTask;
import io.github.orionlibs.core.calendar.time.tasks.HashCodeForTimeTask;
import io.github.orionlibs.core.string.StringsService;

class TimeInternalService extends OrionService
{
    public static int hashCode(Time time)
    {
        return HashCodeForTimeTask.run(time);
    }


    public static boolean equals(Time time, Object other)
    {
        return EqualsForTimeTask.run(time, other);
    }


    public static String formatHoursString(Time time)
    {
        return StringsService.formatWith2Characters(time.getHours());
    }


    public static String formatMinutesString(Time time)
    {
        return StringsService.formatWith2Characters(time.getMinutes());
    }


    public static String formatSecondsString(Time time)
    {
        return StringsService.formatWith2Characters(time.getSeconds());
    }
}