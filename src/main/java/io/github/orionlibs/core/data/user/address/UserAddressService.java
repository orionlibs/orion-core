package io.github.orionlibs.core.data.user.address;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.data.user.address.data_access.OrionUserAddressModel;
import io.github.orionlibs.core.data.user.address.data_access.OrionUserAddressesDAO;
import java.util.List;
import java.util.Set;

public class UserAddressService extends OrionService
{
    public static Set<String> getInvalidFields(OrionUserAddressModel model)
    {
        return InvalidFieldsBO.of(model).getInvalidFieldsForAddress();
    }


    public static boolean isValidAddress(OrionUserAddressModel address)
    {
        return UserAddressBO.of(address).isValidAddress();
    }


    public static boolean isInvalidAddress(OrionUserAddressModel address)
    {
        return !isValidAddress(address);
    }


    public static boolean isValidHouseNumber(OrionUserAddressModel address)
    {
        return UserAddressBO.of(address).isValidHouseNumber();
    }


    public static boolean isInvalidHouseNumber(OrionUserAddressModel address)
    {
        return !isValidHouseNumber(address);
    }


    public static boolean isValidHouseAddressLines(OrionUserAddressModel address)
    {
        return UserAddressBO.of(address).isValidHouseAddressLines();
    }


    public static boolean isInvalidHouseAddressLines(OrionUserAddressModel address)
    {
        return !isValidHouseAddressLines(address);
    }


    public static boolean isValidPostcode(OrionUserAddressModel address)
    {
        return PostcodeBO.of(address.getPostcode()).isValidPostcode();
    }


    public static boolean isInvalidPostcode(OrionUserAddressModel address)
    {
        return !isValidPostcode(address);
    }


    public static void normaliseAddress(OrionUserAddressModel address)
    {
        UserAddressBO.of(address).normaliseAddress();
    }


    public static boolean isValidPostcode(String postcode, String postcodePattern)
    {
        return PostcodeBO.of(postcode).isValidPostcode(postcodePattern);
    }


    public static String getPostcodePrefix(String postcode)
    {
        return PostcodeBO.of(postcode).getPostcodePrefix();
    }


    public static String getPostcodePrefixWithoutUsingGoogleMaps(String postcode)
    {
        return PostcodeBO.of().getPostcodePrefixWithoutUsingGoogleMaps(postcode);
    }


    public static long getNumberOfUserAddressesbyUserID(String userID)
    {
        return OrionUserAddressesDAO.getNumberOfUserAddressesbyUserID(userID);
    }


    public static long getNumberOfPrimaryUserAddressesbyUserID(String userID)
    {
        return OrionUserAddressesDAO.getNumberOfPrimaryUserAddressesbyUserID(userID);
    }


    public static long getNumberOfBillingUserAddressesbyUserID(String userID)
    {
        return OrionUserAddressesDAO.getNumberOfBillingUserAddressesbyUserID(userID);
    }


    public static OrionUserAddressModel getUserAddressByAddressID(String addressID)
    {
        return OrionUserAddressesDAO.getByAddressID(addressID);
    }


    public static OrionUserAddressModel getUserBillingAddressByUserID(String userID)
    {
        return OrionUserAddressesDAO.getBillingAddressByUserID(userID);
    }


    public static List<OrionUserAddressModel> getUserAddressesByUserID(String userID)
    {
        return OrionUserAddressesDAO.getUserAddressesByUserID(userID);
    }


    public static OrionUserAddressModel getPrimaryUserAddressByUserID(String userID)
    {
        return OrionUserAddressesDAO.getPrimaryUserAddressByUserID(userID);
    }


    public static List<OrionUserAddressModel> getUserAddresses()
    {
        return OrionUserAddressesDAO.getAll();
    }


    public static OrionUserAddressModel getOldestUserAddressByUserID(String userID)
    {
        return OrionUserAddressesDAO.getOldestAddressByUserID(userID);
    }


    public static OrionUserAddressModel getNewestUserAddressByUserID(String userID)
    {
        return OrionUserAddressesDAO.getNewestUserAddressByUserID(userID);
    }


    public static int saveUserAddress(OrionUserAddressModel model)
    {
        return OrionUserAddressesDAO.save(model);
    }


    public static int updateUserAddressByAddressID(OrionUserAddressModel model)
    {
        return OrionUserAddressesDAO.update(model);
    }


    public static int deleteUserAddressByID(String addressID)
    {
        return OrionUserAddressesDAO.deleteByAddressID(addressID);
    }


    public static String minifyUKCountryName(String countryName)
    {
        if(countryName != null && "United Kingdom of Great Britain and Northern Ireland".equals(countryName))
        {
            return "U.K.";
        }
        else
        {
            return countryName;
        }
    }
}