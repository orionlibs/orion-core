package io.github.orionlibs.orion.core.calendar.calculation.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.calendar.CalendarService;
import io.github.orionlibs.orion.core.calendar.WeekPeriod;
import io.github.orionlibs.orion.core.calendar.date.Date;
import io.github.orionlibs.orion.core.calendar.datetime.DateTime;
import java.util.ArrayList;
import java.util.List;

public class GetAllWeeksOfTheLastNWeeksAsPairsOfStartAndEndDateWithFirstDayOfWeekBeingSundayTask extends Orion
{
    public static List<WeekPeriod> run(int numberOfWeeksToReturn)
    {
        List<WeekPeriod> weeks = new ArrayList<>();
        Date lastSaturday = CalendarService.getLastSaturdayDateBasedOnCurrentDate();
        DateTime lastSaturdayTemp = DateTime.of(lastSaturday);

        for(int i = 0; i < numberOfWeeksToReturn; i++)
        {
            int daysToSubtractToFindStartOfWeek = (-7 * i) - 6;
            Date startOfWeek = CalendarService.addDaysToDatetime(lastSaturdayTemp, daysToSubtractToFindStartOfWeek).getDate();
            weeks.add(CalendarService.buildWeekPeriodSplitByHyphensYearFirst(startOfWeek.getDateStringSplitByHyphensYearFirst()));
        }

        return weeks;
    }
}