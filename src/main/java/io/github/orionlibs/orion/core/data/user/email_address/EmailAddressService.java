package io.github.orionlibs.orion.core.data.user.email_address;

import io.github.orionlibs.orion.core.abstraction.OrionService;

public class EmailAddressService extends OrionService
{
    public static String normaliseEmailAddress(String emailAddress)
    {
        return EmailAddressBO.of(emailAddress).normaliseEmailAddress();
    }


    public static boolean isValidEmailAddress(String emailAddress)
    {
        return EmailAddressBO.of(emailAddress).isValidEmailAddress();
    }


    public static boolean isInvalidEmailAddress(String emailAddress)
    {
        return !isValidEmailAddress(emailAddress);
    }
}