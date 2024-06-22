package io.github.orionlibs.core.calendar;

import io.github.orionlibs.core.abstraction.Orion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MonthYear extends Orion
{
    private String monthYearID;
    private String month;
    private String year;


    public static MonthYear of()
    {
        return MonthYear.builder().build();
    }
}