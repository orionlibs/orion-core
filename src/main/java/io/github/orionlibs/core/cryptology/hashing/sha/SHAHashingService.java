package io.github.orionlibs.core.cryptology.hashing.sha;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.cryptology.hashing.HashingAlgorithm;
import io.github.orionlibs.core.cryptology.hashing.sha.tasks.EncodeDataToSHATask;

public class SHAHashingService extends OrionService
{
    public static String encodeDataToSHA1(String data)
    {
        return EncodeDataToSHATask.run(data, HashingAlgorithm.SHA1);
    }


    public static String encodeDataToSHA256(String data)
    {
        return EncodeDataToSHATask.run(data, HashingAlgorithm.SHA256);
    }


    public static String encodeDataToSHA512(String data)
    {
        return EncodeDataToSHATask.run(data, HashingAlgorithm.SHA512);
    }
}