package io.github.orionlibs.core.calendar.tasks.format;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.FormattedDateTime;
import io.github.orionlibs.core.calendar.date.InvalidDateException;
import io.github.orionlibs.core.calendar.datetime.DateTime;
import io.github.orionlibs.core.calendar.datetime.DateTimeRules;

public class GetFormattedDateTimeTask extends Orion
{
    public static FormattedDateTime run(DateTime datetime) throws InvalidDateException
    {
        DateTimeRules.isValid(datetime);
        FormattedDateTime formattedDateTime = new FormattedDateTime();
        if(datetime.getDate() != null)
        {
            formattedDateTime.setDateSplitByHyphens(datetime.getDate().getDateStringSplitByHyphens());
            formattedDateTime.setDateSplitByHyphensYearFirst(datetime.getDate().getDateStringSplitByHyphensYearFirst());
            formattedDateTime.setDateSplitBySlashes(datetime.getDate().getDateStringSplitBySlashes());
            formattedDateTime.setDateSplitBySlashesYearFirst(datetime.getDate().getDateStringSplitBySlashesYearFirst());
            formattedDateTime.setLongDate(datetime.getDate().getLongDateYearFirstString());
        }
        if(datetime.getTime() != null)
        {
            formattedDateTime.setTime(datetime.getTime().getTimeString());
            formattedDateTime.setTimeWithISOFormat(datetime.getTime().getTimeStringInISOFormat());
        }
        return formattedDateTime;
    }
}