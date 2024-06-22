package io.github.orionlibs.core.data.user.phone_number;

import io.github.orionlibs.core.abstraction.OrionService;

public class PhoneNumberService extends OrionService
{
    public static boolean isValidPhoneNumber(String phoneNumber, String phoneNumberRegionCode)
    {
        return PhoneNumberBO.of(phoneNumber, phoneNumberRegionCode).isValid();
    }


    public static boolean isValidPhoneNumber(String phoneNumber, PhoneNumberRegionCode phoneNumberRegionCode)
    {
        return PhoneNumberBO.of(phoneNumber, phoneNumberRegionCode.get()).isValid();
    }


    public static boolean isInvalidPhoneNumber(String phoneNumber, String phoneNumberRegionCode)
    {
        return !isValidPhoneNumber(phoneNumber, phoneNumberRegionCode);
    }


    public static boolean isInvalidPhoneNumber(String phoneNumber, PhoneNumberRegionCode phoneNumberRegionCode)
    {
        return !isValidPhoneNumber(phoneNumber, phoneNumberRegionCode);
    }


    public static String normalisePhoneNumber(String phoneNumber, String phoneNumberRegionCode)
    {
        return PhoneNumberBO.of(phoneNumber, phoneNumberRegionCode).normalise();
    }


    public static String normalisePhoneNumber(String phoneNumber, PhoneNumberRegionCode phoneNumberRegionCode)
    {
        return PhoneNumberBO.of(phoneNumber, phoneNumberRegionCode).normalise();
    }


    public static String convertPhoneNumberToInternationalFormat(String phoneNumber, PhoneNumberRegionCode phoneNumberRegionCode)
    {
        return PhoneNumberBO.of(phoneNumber, phoneNumberRegionCode).convertToInternationalFormat();
    }


    public static String convertPhoneNumberToInternationalFormat(String phoneNumber, String phoneNumberRegionCode)
    {
        return PhoneNumberBO.of(phoneNumber, phoneNumberRegionCode).convertToInternationalFormat();
    }
}