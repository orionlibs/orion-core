package io.github.orionlibs.core.file_system.file.tasks;

import io.github.orionlibs.core.abstraction.Orion;

public class GetFileExtensionTask extends Orion
{
    public static String run(String fileName)
    {

        if(fileName != null && !fileName.isEmpty() && fileName.lastIndexOf(".") >= 0)
        {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        else
        {
            return "";
        }

    }
}