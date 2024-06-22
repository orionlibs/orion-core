package io.github.orionlibs.core.calendar.conversion.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.Calendar;
import io.github.orionlibs.core.calendar.DateTokens;

public class ConvertDateToLongFormatWithoutYearTask extends Orion
{
    public static String run(DateTokens dateParts)
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(dateParts.getDays());
        sb.append(" ");
        sb.append(Calendar.monthNumberToAbbreviatedNameMapper.get(dateParts.getMonth()));
        return sb.toString();
    }
}