package io.github.orionlibs.core.calendar.calculation.tasks.difference;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.time.Time;
import io.github.orionlibs.core.calendar.time.TimeRules;
import io.github.orionlibs.core.exception.InvalidArgumentException;
import java.time.temporal.ChronoUnit;

public class GetDifferenceBetweenTwoTimesInMillisecondsTask extends Orion
{
    public static long run(Time time1, Time time2) throws InvalidArgumentException
    {
        TimeRules.isValid(time1);
        TimeRules.isValid(time2);
        return ChronoUnit.MILLIS.between(time1.toLocalTime(), time2.toLocalTime());
    }
}
