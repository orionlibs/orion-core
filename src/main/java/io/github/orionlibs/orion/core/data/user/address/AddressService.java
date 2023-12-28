package io.github.orionlibs.orion.core.data.user.address;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.data.user.address.data_access.OrionAddress;
import io.github.orionlibs.orion.core.utility.OrionUtils;

public class AddressService extends OrionService
{
    public static String formatIn1Line(Object address)
    {
        return OrionUtils.copyFields(address, new OrionAddress()).formatIn1Line();
    }


    public static String formatIn1LineWithoutCountry(Object address)
    {
        return OrionUtils.copyFields(address, new OrionAddress()).formatIn1LineWithoutCountry();
    }


    public static String formatIn1LineWithoutPostcodeOrCountry(Object address)
    {
        return OrionUtils.copyFields(address, new OrionAddress()).formatIn1LineWithoutPostcodeOrCountry();
    }
}