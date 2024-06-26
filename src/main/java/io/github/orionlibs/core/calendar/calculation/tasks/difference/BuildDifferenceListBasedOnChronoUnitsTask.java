package io.github.orionlibs.core.calendar.calculation.tasks.difference;

import io.github.orionlibs.core.abstraction.Orion;
import java.util.List;

class BuildDifferenceListBasedOnChronoUnitsTask extends Orion
{
    static Long[] run(DateTimeDifference dateTimeDifference)
    {
        List<String> unitsToUse = dateTimeDifference.getUnitsToUse();
        Long[] durationList = new Long[unitsToUse.size()];

        for(int i = 0; i < unitsToUse.size(); i++)
        {

            if("y".equals(unitsToUse.get(i)))
            {
                durationList[i] = dateTimeDifference.getNumberOfYears();
            }
            else if("M".equals(unitsToUse.get(i)))
            {
                durationList[i] = dateTimeDifference.getNumberOfMonths();
            }
            else if("W".equals(unitsToUse.get(i)))
            {
                durationList[i] = dateTimeDifference.getNumberOfWeeks();
            }
            else if("d".equals(unitsToUse.get(i)))
            {
                durationList[i] = dateTimeDifference.getNumberOfDays();
            }
            else if("h".equals(unitsToUse.get(i)))
            {
                durationList[i] = dateTimeDifference.getNumberOfHours();
            }
            else if("m".equals(unitsToUse.get(i)))
            {
                durationList[i] = dateTimeDifference.getNumberOfMinutes();
            }
            else if("s".equals(unitsToUse.get(i)))
            {
                durationList[i] = dateTimeDifference.getNumberOfSeconds();
            }

        }

        return durationList;
    }
}
