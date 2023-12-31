package io.github.orionlibs.orion.core.net.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;

public class ConvertStringToByteWithoutOverflowingTask extends Orion
{
    public static void run(byte[] IPAddressTemp, short aByte, int i)
    {

        if(aByte > Byte.MAX_VALUE)
        {
            aByte -= 256;
        }

        IPAddressTemp[i] = Byte.parseByte(Short.toString(aByte));
    }
}