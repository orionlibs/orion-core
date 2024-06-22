package io.github.orionlibs.core.security.annotations.service;

import io.github.orionlibs.core.abstraction.OrionEnumeration;
import io.github.orionlibs.core.cryptology.encryption.rsa.RSAEncryptionException;
import io.github.orionlibs.core.cryptology.hashing.md5.MD5HashingException;
import io.github.orionlibs.core.exception.InaccessibleException;
import io.github.orionlibs.core.security.annotations.EncryptAsUsername;
import java.lang.reflect.Field;
import java.util.List;

public class EncryptAsUsernameAnnotationService extends EncryptionDecryptionAnnotationService
{
    public void encryptObject(Object objectToEncrypt, List<Field> instanceVariablesOfObject, List<OrionEnumeration> encodingAndEncryptionAlgorithmsForUsernameToBeUsedInOrder)
    {
        processInputs(objectToEncrypt, encodingAndEncryptionAlgorithmsForUsernameToBeUsedInOrder);
        instanceVariablesOfObject.forEach(field ->
        {

            try
            {
                processInstanceVariableForEncryption(field);
            }
            catch(IllegalArgumentException e)
            {
                throw e;
            }
            catch(IllegalAccessException e)
            {
                //throw new InaccessibleException("The instance variable is inaccessible.");
            }
            catch(InaccessibleException e)
            {
                //
            }
            catch(MD5HashingException e)
            {
                //
            }
            catch(RSAEncryptionException e)
            {
                //
            }

        });
    }


    private void processInstanceVariableForEncryption(Field instanceVariable) throws IllegalArgumentException, IllegalAccessException, InaccessibleException, MD5HashingException, RSAEncryptionException
    {

        if(instanceVariable.getAnnotation(EncryptAsUsername.class) != null)
        {
            encryptData(instanceVariable);
        }

    }
}