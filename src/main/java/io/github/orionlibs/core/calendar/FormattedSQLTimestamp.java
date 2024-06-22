package io.github.orionlibs.core.calendar;

import io.github.orionlibs.core.abstraction.Orion;

public class FormattedSQLTimestamp extends Orion
{
    public static void setupFormattedDateTime(SQLTimestamp timestamp)
    {
        SQLTimestampFormatter formatter = SQLTimestampFormatter.builder()
                        .timestamp(timestamp)
                        .build();
        formatter.setupFormattedDateTime();
    }


    public static void setupFormattedDateTimeUTC(SQLTimestamp timestamp)
    {
        SQLTimestampFormatter formatter = SQLTimestampFormatter.builder()
                        .timestamp(timestamp)
                        .build();
        formatter.setupFormattedDateTimeUTC();
    }
}