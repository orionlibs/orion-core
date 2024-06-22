package io.github.orionlibs.core.comparator;

import io.github.orionlibs.core.abstraction.Orion;
import java.math.BigDecimal;
import java.util.Comparator;

public class NumberComparator extends Orion implements Comparator<Number>
{
    @Override
    public int compare(Number x, Number y)
    {
        BigDecimal number1 = new BigDecimal(x.toString());
        BigDecimal number2 = new BigDecimal(y.toString());
        return (number1).compareTo(number2);
    }
}