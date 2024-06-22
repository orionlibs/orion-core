package io.github.orionlibs.core.calendar.stopwatch.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.Calendar;
import io.github.orionlibs.core.calendar.stopwatch.Stopwatch;
import io.github.orionlibs.core.exception.Assert;

public class GetTimeLapsedWithNanosecondsTask extends Orion
{
    public static String run(Stopwatch stopwatch, String timeElapsed)
    {
        Assert.notNull(stopwatch, "The stopwatch input cannot be null.");
        Assert.notEmpty(timeElapsed, "The timeElapsed input cannot be null/empty.");
        long totalSecondsElapsed = stopwatch.getTotalSecondsElapsed();
        long totalMinutesElapsed = stopwatch.getTotalMinutesElapsed();
        long totalHoursElapsed = stopwatch.getTotalHoursElapsed();
        long totalHoursInSeconds = totalHoursElapsed * Calendar.secondsInAMinute;
        long totalMinutesInSeconds = totalMinutesElapsed * Calendar.secondsInAMinute;
        totalSecondsElapsed += totalMinutesInSeconds + totalHoursInSeconds;
        long nanoseconds = stopwatch.getNanosecondsElapsed() - (totalSecondsElapsed * Calendar.nanosecondsInASecond);
        return timeElapsed + "." + nanoseconds;
    }
}