package io.github.orionlibs.orion.core.calendar;

import io.github.orionlibs.orion.core.abstraction.Orion;
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