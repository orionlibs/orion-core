package io.github.orionlibs.orion.core.data.user.address;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.data.geodata.country.CountryService;
import io.github.orionlibs.orion.core.data.user.address.data_access.OrionUserAddressModel;
import io.github.orionlibs.orion.core.exception.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserAddressBO extends Orion
{
    private OrionUserAddressModel address;


    public static UserAddressBO of(OrionUserAddressModel address)
    {
        return UserAddressBO.builder().address(address).build();
    }


    public boolean isValidAddress()
    {
        Assert.notNull(address, "The given address cannot be null.");
        return ((address.getHouseAddressLine1() != null && !address.getHouseAddressLine1().isEmpty())
                        || (address.getHouseAddressLine2() != null && !address.getHouseAddressLine2().isEmpty()))
                        && address.getPostcode() != null && !address.getPostcode().isEmpty();
    }


    public boolean isValidHouseNumber()
    {
        return address.getHouseNumber() != null && !address.getHouseNumber().isEmpty();
    }


    public boolean isValidHouseAddressLines()
    {
        return (address.getHouseAddressLine1() != null && !address.getHouseAddressLine1().isEmpty())
                        || (address.getHouseAddressLine2() != null && !address.getHouseAddressLine2().isEmpty());
    }


    public boolean isValidCountryCodeAlpha2()
    {
        return CountryService.getCountryShortNameFromCodeAlpha2(address.getCountryCodeAlpha2().trim().toUpperCase()) != null;
    }


    public void normaliseAddress()
    {
        Assert.notNull(address, "The given address cannot be null.");

        if(address.getHouseNumber() != null && !address.getHouseNumber().isEmpty())
        {
            address.setHouseNumber(address.getHouseNumber().trim());
        }

        if((address.getHouseAddressLine1() == null || address.getHouseAddressLine1().isEmpty())
                        && address.getHouseAddressLine2() != null && !address.getHouseAddressLine2().isEmpty())
        {
            address.setHouseAddressLine1(address.getHouseAddressLine2());
            address.setHouseAddressLine2(null);
        }

        if(address.getHouseAddressLine1() != null && !address.getHouseAddressLine1().isEmpty())
        {
            address.setHouseAddressLine1(address.getHouseAddressLine1().trim());
        }

        if(address.getHouseAddressLine2() != null && !address.getHouseAddressLine2().isEmpty())
        {
            address.setHouseAddressLine2(address.getHouseAddressLine2().trim());
        }

        if(address.getCounty() != null && !address.getCounty().isEmpty())
        {
            address.setCounty(address.getCounty().trim());
        }

        if(address.getCity() != null && !address.getCity().isEmpty())
        {
            address.setCity(address.getCity().trim());
        }

        address.setPostcode(address.getPostcode().trim());
        address.setCountryCodeAlpha2(address.getCountryCodeAlpha2().trim().toUpperCase());
        address.setCountry(CountryService.getCountryShortNameFromCodeAlpha2(address.getCountryCodeAlpha2()));
    }
}