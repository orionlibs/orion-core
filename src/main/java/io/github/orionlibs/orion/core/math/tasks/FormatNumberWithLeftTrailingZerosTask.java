package io.github.orionlibs.orion.core.math.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;

public class FormatNumberWithLeftTrailingZerosTask extends Orion
{
    public static String run(long number, int numberOfTrailingZeros)
    {
        return String.format("%0" + numberOfTrailingZeros + "d", number);
    }
}