package io.github.orionlibs.core.data.user.address;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.data.user.address.data_access.OrionAddress;
import io.github.orionlibs.core.utility.OrionUtils;

public class AddressService extends OrionService
{
    public static String formatIn1Line(Object address)
    {
        return OrionUtils.copyFields(address, new OrionAddress()).formatIn1Line();
    }


    public static String formatIn1LineWithoutCountry(Object address)
    {

        if(address != null)
        {
            return OrionUtils.copyFields(address, new OrionAddress()).formatIn1LineWithoutCountry();
        }
        else
        {
            return "";
        }

    }


    public static String formatIn1LineWithoutPostcodeOrCountry(Object address)
    {
        return OrionUtils.copyFields(address, new OrionAddress()).formatIn1LineWithoutPostcodeOrCountry();
    }
}