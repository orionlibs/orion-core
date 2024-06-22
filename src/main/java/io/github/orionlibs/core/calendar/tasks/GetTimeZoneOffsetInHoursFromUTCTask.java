package io.github.orionlibs.core.calendar.tasks;

import io.github.orionlibs.core.calendar.CalendarService;
import io.github.orionlibs.core.calendar.datetime.DateTime;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class GetTimeZoneOffsetInHoursFromUTCTask
{
    public static int run(DateTime datetime)
    {
        ZonedDateTime zonedDateTime = CalendarService.convertDatetimeToZonedDatetime(datetime);
        TimeZone timezone = TimeZone.getTimeZone(datetime.getZoneID());
        int timezoneOffset = timezone.getOffset(zonedDateTime.toInstant().getEpochSecond());
        return timezoneOffset / 3_600_000;
    }
}