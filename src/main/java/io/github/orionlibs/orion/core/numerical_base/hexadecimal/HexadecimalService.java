package io.github.orionlibs.orion.core.numerical_base.hexadecimal;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.numerical_base.hexadecimal.tasks.ConvertToHexadecimalBaseTask;

public class HexadecimalService extends OrionService
{
    public static String convertToHexadecimalBase(String data)
    {
        return ConvertToHexadecimalBaseTask.run(data.getBytes());
    }


    public static String convertToHexadecimalBase(byte[] data)
    {
        return ConvertToHexadecimalBaseTask.run(data);
    }
}