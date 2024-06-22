package io.github.orionlibs.core.calendar.calculation.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.Calendar;
import io.github.orionlibs.core.calendar.CalendarRules;
import io.github.orionlibs.core.calendar.datetime.DateTime;
import io.github.orionlibs.core.calendar.datetime.DateTimeRules;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class AddYearsToDatetimeTask extends Orion
{
    public static DateTime run(DateTime datetime, int numberOfYears, ZoneId zone)
    {
        DateTimeRules.isValidIgnoringZoneID(datetime);
        CalendarRules.isValid(zone);
        LocalDate localDate = datetime.toLocalDate().plus(numberOfYears, ChronoUnit.YEARS);
        LocalDateTime localDateTime = LocalDateTime.of(localDate.getYear(),
                        localDate.getMonthValue(),
                        localDate.getDayOfMonth(),
                        datetime.getTime().getHours(),
                        datetime.getTime().getMinutes(),
                        datetime.getTime().getSeconds(),
                        datetime.getTime().getMilliseconds() * Calendar.nanosecondsInAMillisecond);
        return DateTime.of(ZonedDateTime.of(localDateTime, zone));
    }
}