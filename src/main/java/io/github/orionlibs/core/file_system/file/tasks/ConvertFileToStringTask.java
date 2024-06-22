package io.github.orionlibs.core.file_system.file.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.utility.OrionUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConvertFileToStringTask extends Orion
{
    public static String run(BufferedReader input) throws FileNotFoundException, IOException
    {
        Assert.notNull(input, "BufferedReader input cannot be null.");
        String currentLine = null;
        StringBuilder fileStringBuilder = new StringBuilder();

        try
        {

            while((currentLine = input.readLine()) != null)
            {
                fileStringBuilder.append(currentLine);
                fileStringBuilder.append(System.lineSeparator());
            }

            //fileStringBuilder = StringsService.deleteLineSeparatorFromTheEnd(fileStringBuilder);
        }
        finally
        {
            OrionUtils.closeResource(input);
        }

        return fileStringBuilder.toString();
    }
}