package io.github.orionlibs.core.data.validation;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.exception.InvalidArgumentException;

public class ValidationService extends OrionService
{
    public static boolean isObjectValid(Object object)
    {
        InvalidFields invalidInstanceVariableNames = ValidationBO.of(object).validate();
        return invalidInstanceVariableNames == null || invalidInstanceVariableNames.isEmpty();
    }


    public static void isObjectValidOrThrowException(Object object)
    {
        InvalidFields invalidInstanceVariableNames = ValidationBO.of(object).validate();
        if(invalidInstanceVariableNames != null && !invalidInstanceVariableNames.isEmpty())
        {
            throw new InvalidArgumentException();
        }
    }


    public static InvalidFields validateObjectAndGetInvalidInstanceVariables(Object object)
    {
        return ValidationBO.of(object).validate();
    }
}