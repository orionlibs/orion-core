package io.github.orionlibs.orion.core.file_system.file.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.exception.Assert;
import io.github.orionlibs.orion.core.utility.OrionUtils;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFirstLineFromFileTask extends Orion
{
    public static String run(BufferedReader input) throws IOException
    {
        Assert.notNull(input, "BufferedReader input cannot be null.");

        try
        {
            return input.readLine();
        }
        finally
        {
            OrionUtils.closeResource(input);
        }

    }
}