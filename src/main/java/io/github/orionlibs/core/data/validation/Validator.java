package io.github.orionlibs.core.data.validation;

public interface Validator
{
    public default boolean isValid()
    {
        return ValidationService.isObjectValid(this);
    }


    public default void isObjectValidOrThrowException()
    {
        ValidationService.isObjectValidOrThrowException(this);
    }


    public default InvalidFields isValidAndGetErrors()
    {
        return ValidationService.validateObjectAndGetInvalidInstanceVariables(this);
    }
}