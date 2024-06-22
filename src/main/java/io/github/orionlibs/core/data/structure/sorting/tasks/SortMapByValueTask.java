package io.github.orionlibs.core.data.structure.sorting.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMapByValueTask extends Orion
{
    public static List<Entry<?, ?>> run(Map<?, ?> map)
    {
        List<Map.Entry<?, ?>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<?, ?>>()
        {
            public int compare(Map.Entry<?, ?> o1, Map.Entry<?, ?> o2)
            {

                if(o1.getValue() instanceof Number && o2.getValue() instanceof Number)
                {
                    BigDecimal number1 = new BigDecimal(o1.getValue().toString());
                    BigDecimal number2 = new BigDecimal(o2.getValue().toString());
                    return (number1).compareTo(number2);
                }
                else
                {
                    return 0;
                }

            }
        });
        return list;
    }
}