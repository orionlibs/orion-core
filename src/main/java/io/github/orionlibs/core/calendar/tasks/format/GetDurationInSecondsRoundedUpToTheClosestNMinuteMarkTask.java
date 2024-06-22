package io.github.orionlibs.core.calendar.tasks.format;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.Calendar;

public class GetDurationInSecondsRoundedUpToTheClosestNMinuteMarkTask extends Orion
{
    public static long run(int numberOfMinutes, long durationInSeconds)
    {
        long secondsInNMinutes = Calendar.secondsInAMinute * numberOfMinutes;
        long excessSecondsAfterMultipleOfNMinutes = durationInSeconds % secondsInNMinutes;

        if(excessSecondsAfterMultipleOfNMinutes != 0)
        {
            durationInSeconds += secondsInNMinutes - (durationInSeconds % secondsInNMinutes);
        }

        return durationInSeconds;
    }
}