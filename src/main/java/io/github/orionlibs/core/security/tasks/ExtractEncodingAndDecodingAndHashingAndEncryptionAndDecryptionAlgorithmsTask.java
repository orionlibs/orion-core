package io.github.orionlibs.core.security.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.abstraction.OrionEnumeration;
import io.github.orionlibs.core.cryptology.encoding.EncodingAlgorithm;
import io.github.orionlibs.core.cryptology.encryption.EncryptionAlgorithm;
import io.github.orionlibs.core.cryptology.hashing.HashingAlgorithm;
import io.github.orionlibs.core.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import java.util.ArrayList;
import java.util.List;

public class ExtractEncodingAndDecodingAndHashingAndEncryptionAndDecryptionAlgorithmsTask extends Orion
{
    public static List<OrionEnumeration> run(String[] algorithmsToBeUsedInOrder) throws NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        List<OrionEnumeration> algorithmsToBeUsedInOrderList = new ArrayList<>();

        for(String algorithm : algorithmsToBeUsedInOrder)
        {
            EncodingAlgorithm encodingDecodingAlgorithm = EncodingAlgorithm.getEnumForValue(algorithm);

            if(encodingDecodingAlgorithm != null)
            {
                algorithmsToBeUsedInOrderList.add(encodingDecodingAlgorithm);
            }
            else
            {
                HashingAlgorithm hashingAlgorithm = HashingAlgorithm.getEnumForValue(algorithm);

                if(hashingAlgorithm != null)
                {
                    algorithmsToBeUsedInOrderList.add(hashingAlgorithm);
                }
                else
                {
                    EncryptionAlgorithm encryptionDecryptionAlgorithm = EncryptionAlgorithm.getEnumForValue(algorithm);

                    if(encryptionDecryptionAlgorithm != null)
                    {
                        algorithmsToBeUsedInOrderList.add(encryptionDecryptionAlgorithm);
                    }

                }

            }

        }

        if(algorithmsToBeUsedInOrderList.isEmpty())
        {
            throw new NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException();
        }

        return algorithmsToBeUsedInOrderList;
    }
}