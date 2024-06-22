package io.github.orionlibs.core.data.geodata.country.data_access;

import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.object.CloningService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This class does not extend OrionModel, because that inheritance does not
// allow
// the use of Lombok's @SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CountryModel implements OrionModel
{
    private String countryCodeAlpha2;
    private String countryCodeAlpha3;
    private String countryCodeNumeric;
    private String countryShortName;
    private String countryLongName;
    private String continentCode;


    public static CountryModel of()
    {
        return CountryModel.builder().build();
    }


    public static CountryModel of(String countryCodeAlpha2)
    {
        return CountryModel.builder().countryCodeAlpha2(countryCodeAlpha2).build();
    }


    @Override
    public CountryModel clone()
    {
        return (CountryModel)CloningService.clone(this);
    }


    @Override
    public CountryModel getCopy()
    {
        return this.clone();
    }
}