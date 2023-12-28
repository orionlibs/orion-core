package io.github.orionlibs.orion.core.calendar.calculation.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.calendar.date.Date;
import io.github.orionlibs.orion.core.calendar.date.DateRules;
import io.github.orionlibs.orion.core.calendar.datetime.DateTime;
import io.github.orionlibs.orion.core.calendar.datetime.DateTimeRules;
import io.github.orionlibs.orion.core.exception.InvalidArgumentException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GetNumberOfMonthDaysTask extends Orion
{
    public static int run(Date date) throws InvalidArgumentException
    {
        DateRules.isValid(date);
        Calendar calendar = new GregorianCalendar(date.getYear(), date.getMonth() - 1, date.getDay());
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    public static int run(DateTime date) throws InvalidArgumentException
    {
        DateTimeRules.isValidIgnoringZoneID(date);
        DateRules.isValid(date.getDate());
        return run(date.getDate());
    }
}