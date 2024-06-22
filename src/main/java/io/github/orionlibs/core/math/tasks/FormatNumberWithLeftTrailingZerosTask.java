package io.github.orionlibs.core.math.tasks;

import io.github.orionlibs.core.abstraction.Orion;

public class FormatNumberWithLeftTrailingZerosTask extends Orion
{
    public static String run(long number, int numberOfTrailingZeros)
    {
        return String.format("%0" + numberOfTrailingZeros + "d", number);
    }
}