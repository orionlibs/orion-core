package io.github.orionlibs.core.data.user.username;

import io.github.orionlibs.core.abstraction.OrionEnumeration;
import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.cryptology.encryption.rsa.RSAEncryptionException;
import io.github.orionlibs.core.cryptology.hashing.md5.MD5HashingException;
import io.github.orionlibs.core.security.DataSecurityService;
import io.github.orionlibs.core.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import java.util.List;

public class UsernameService extends OrionService
{
    public static String encryptUsername(String rawUsername) throws MD5HashingException, RSAEncryptionException, NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        return DataSecurityService.encryptUsername(rawUsername);
    }


    public static String encryptUsername(String rawUsername, List<OrionEnumeration> encodingAndEncryptionAlgorithmsToBeUsedInOrder) throws MD5HashingException, RSAEncryptionException
    {
        return DataSecurityService.encryptData(rawUsername, encodingAndEncryptionAlgorithmsToBeUsedInOrder);
    }


    public static String decryptUsername(String encryptedUsername) throws MD5HashingException, RSAEncryptionException, NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        return DataSecurityService.decryptUsername(encryptedUsername);
    }


    public static String decryptUsername(String encryptedUsername, List<OrionEnumeration> decodingAndDecryptionAlgorithmsToBeUsedInOrder) throws MD5HashingException, RSAEncryptionException
    {
        return DataSecurityService.decryptData(encryptedUsername, decodingAndDecryptionAlgorithmsToBeUsedInOrder);
    }
}