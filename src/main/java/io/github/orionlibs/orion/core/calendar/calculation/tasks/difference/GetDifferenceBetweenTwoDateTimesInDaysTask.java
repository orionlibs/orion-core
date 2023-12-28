package io.github.orionlibs.orion.core.calendar.calculation.tasks.difference;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.calendar.datetime.DateTime;
import io.github.orionlibs.orion.core.calendar.datetime.DateTimeRules;
import io.github.orionlibs.orion.core.exception.InvalidArgumentException;
import java.time.temporal.ChronoUnit;

public class GetDifferenceBetweenTwoDateTimesInDaysTask extends Orion
{
    public static long run(DateTime date1, DateTime date2) throws InvalidArgumentException
    {
        DateTimeRules.isValid(date1);
        DateTimeRules.isValid(date2);
        return ChronoUnit.DAYS.between(date1.toLocalDate(), date2.toLocalDate());
    }
}
