package io.github.orionlibs.core.cryptology.encoding.ascii;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.cryptology.encoding.ascii.tasks.DecodeASCIITask;
import io.github.orionlibs.core.cryptology.encoding.ascii.tasks.EncodeToASCIITask;

public class ASCIIEncodingService extends OrionService
{
    public static String encodeToASCII(String data)
    {
        return EncodeToASCIITask.run(data);
    }


    public static String decodeASCII(String data)
    {
        return DecodeASCIITask.run(data);
    }
}