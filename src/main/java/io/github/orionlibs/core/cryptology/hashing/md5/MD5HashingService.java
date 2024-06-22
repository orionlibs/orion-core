package io.github.orionlibs.core.cryptology.hashing.md5;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.cryptology.hashing.md5.tasks.EncodeToMD5Task;
import io.github.orionlibs.core.exception.InvalidArgumentException;
import java.security.NoSuchAlgorithmException;

public class MD5HashingService extends OrionService
{
    public static byte[] encodeToMD5AsBytes(String data, int offset, int length, byte[] signatureKeyBytes) throws NoSuchAlgorithmException, InvalidArgumentException
    {
        return EncodeToMD5Task.run(data, offset, length, signatureKeyBytes);
    }


    public static String encodeToMD5(String data, int offset, int length, byte[] signatureKeyBytes) throws NoSuchAlgorithmException, InvalidArgumentException
    {
        return new String(EncodeToMD5Task.run(data, offset, length, signatureKeyBytes));
    }


    public static byte[] encodeToMD5AsBytes(String data) throws NoSuchAlgorithmException, InvalidArgumentException
    {
        return EncodeToMD5Task.run(data);
    }


    public static String encodeToMD5(String data) throws NoSuchAlgorithmException, InvalidArgumentException
    {
        return new String(EncodeToMD5Task.run(data));
    }
}