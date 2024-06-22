package io.github.orionlibs.core.cryptology.encoding.xss;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.cryptology.encoding.xss.tasks.DecodeFromXSSTask;
import io.github.orionlibs.core.cryptology.encoding.xss.tasks.EncodeWithXSSTask;

public class XSSEncodingService extends OrionService
{
    public static String encodeWithXSS(String data)
    {
        return EncodeWithXSSTask.run(data);
    }


    public static String decodeFromXSS(String data)
    {
        return DecodeFromXSSTask.run(data);
    }
}