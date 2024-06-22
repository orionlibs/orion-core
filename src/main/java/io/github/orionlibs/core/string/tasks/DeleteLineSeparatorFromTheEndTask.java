package io.github.orionlibs.core.string.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.operating_system.OperatingSystemService;

public class DeleteLineSeparatorFromTheEndTask extends Orion
{
    public static String run(String aString)
    {
        Assert.notEmpty(aString, "The aString input cannot be null/empty.");

        if(aString.endsWith(System.lineSeparator()))
        {

            if(OperatingSystemService.isLinuxSystem() || OperatingSystemService.isMacOSXSystem())
            {
                return aString.substring(0, aString.length() - 2);
            }
            else if(OperatingSystemService.isWindowsSystem())
            {
                return aString.substring(0, aString.length() - 4);
            }

        }

        return aString;
    }
}