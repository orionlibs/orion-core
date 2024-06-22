package io.github.orionlibs.core.file_system.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class PrintFilesAndDirectoriesTask extends Orion
{
    public static void run(File directoryToTraverse, BufferedWriter output) throws IOException
    {
        Assert.notNull(directoryToTraverse, "directoryToTraverse input cannot be null.");
        Assert.notNull(output, "BufferedWriter input cannot be null.");
        output.write(directoryToTraverse.getAbsolutePath());
        output.write(System.lineSeparator());

        if(directoryToTraverse.isDirectory())
        {
            File[] filesTemp = directoryToTraverse.listFiles();

            for(File file1 : filesTemp)
            {
                run(file1, output);
            }

        }

    }
}