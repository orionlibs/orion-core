package io.github.orionlibs.core.security.annotations.service;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.abstraction.OrionEnumeration;
import io.github.orionlibs.core.cryptology.encryption.rsa.RSAEncryptionException;
import io.github.orionlibs.core.cryptology.hashing.md5.MD5HashingException;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.exception.InaccessibleException;
import io.github.orionlibs.core.reflection.variable.access.ReflectionInstanceVariablesAccessService;
import io.github.orionlibs.core.security.DataSecurityService;
import java.lang.reflect.Field;
import java.util.List;

class EncryptionDecryptionAnnotationService extends Orion
{
    private List<OrionEnumeration> algorithmsForUsernameToBeUsedInOrder;
    private Object objectToEncryptOrDecrypt;


    protected void processInputs(Object objectToEncryptOrDecrypt, List<OrionEnumeration> algorithmsForUsernameToBeUsedInOrder)
    {
        Assert.notNull(objectToEncryptOrDecrypt, "The objectToEncryptOrDecrypt input cannot be null.");
        Assert.notEmpty(algorithmsForUsernameToBeUsedInOrder, "The algorithmsForUsernameToBeUsedInOrder input cannot be null/empty.");
        this.algorithmsForUsernameToBeUsedInOrder = algorithmsForUsernameToBeUsedInOrder;
        this.objectToEncryptOrDecrypt = objectToEncryptOrDecrypt;
    }


    protected void encryptData(Field instanceVariable) throws IllegalArgumentException, IllegalAccessException, InaccessibleException, MD5HashingException, RSAEncryptionException
    {
        String data = (String)instanceVariable.get(objectToEncryptOrDecrypt);
        String encryptedData = DataSecurityService.encryptData(data, algorithmsForUsernameToBeUsedInOrder);
        ReflectionInstanceVariablesAccessService.injectStringToInstanceVariable(objectToEncryptOrDecrypt, encryptedData, instanceVariable);
    }


    protected void decryptData(Field instanceVariable) throws IllegalArgumentException, IllegalAccessException, InaccessibleException, MD5HashingException, RSAEncryptionException
    {
        ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(instanceVariable);
        String data = (String)instanceVariable.get(objectToEncryptOrDecrypt);
        String decryptedData = DataSecurityService.decryptData(data, algorithmsForUsernameToBeUsedInOrder);
        ReflectionInstanceVariablesAccessService.injectStringToInstanceVariable(objectToEncryptOrDecrypt, decryptedData, instanceVariable);
    }
}