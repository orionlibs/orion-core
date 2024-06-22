package io.github.orionlibs.core.calendar.tasks.format;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.CalendarService;
import io.github.orionlibs.core.calendar.date.Date;
import io.github.orionlibs.core.calendar.date.InvalidDateException;
import io.github.orionlibs.core.calendar.datetime.DateTime;

public class PrintDateAsTodayOrTomorrowOrFullDateTimeTask extends Orion
{
    public static String run(DateTime datetime, boolean printYear) throws InvalidDateException
    {

        if(datetime != null)
        {
            Date currentDate = CalendarService.getCurrentDateAdjustingForDaylightSavings();
            String result = "";

            if(datetime.getDate().equals(currentDate))
            {
                result = "today @ " + datetime.printTimeAsIsWithoutSeconds();
            }
            else
            {

                if(datetime.getDate().equals(CalendarService.addDaysToCurrentDatetimeAdjustingForDaylightSavings(1).getDate()))
                {
                    result = "tomorrow @ " + datetime.printTimeAsIsWithoutSeconds();
                }
                else
                {

                    if(printYear)
                    {
                        result = datetime.printInInternationalFormatWithAtSymbolWithoutSeconds();
                    }
                    else
                    {
                        result = datetime.printLongDateWithoutYearWithAtSymbolWithoutSeconds();
                    }

                }

            }

            return result;
        }
        else
        {
            return "";
        }

    }
}