package io.github.orionlibs.orion.core.math.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.exception.Assert;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class FormatNumberTask extends Orion
{
    public static String run(BigDecimal number, int numberOfDecimalDigits)
    {
        Assert.notNull(number, "number input cannot be null.");
        Assert.isNonNegative(numberOfDecimalDigits, "numberOfDecimalDigits input cannot be negative.");
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(numberOfDecimalDigits);
        return formatter.format(number);
    }


    public static String run(long number, String format)
    {
        return String.format(format, number);
    }


    public static String run(long number)
    {
        Assert.notNull(number, "number input cannot be null.");
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(0);
        return formatter.format(number);
    }
}