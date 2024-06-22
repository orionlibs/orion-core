package io.github.orionlibs.core.cryptology.hashing.sha.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.cryptology.hashing.HashingAlgorithm;
import io.github.orionlibs.core.exception.Assert;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeDataToSHATask extends Orion
{
    public static String run(String data, HashingAlgorithm hashingAlgorithm)
    {
        Assert.notEmpty(data, "The given data is null/empty.");
        String encodedData = null;
        MessageDigest md = null;

        try
        {
            md = MessageDigest.getInstance(hashingAlgorithm.get());
            md.update(data.getBytes());
            byte[] byteData = md.digest();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < byteData.length; i++)
            {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            encodedData = sb.toString();
        }
        catch(NoSuchAlgorithmException e)
        {
        }

        return encodedData;
    }
}