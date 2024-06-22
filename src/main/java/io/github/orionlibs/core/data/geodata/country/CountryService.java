package io.github.orionlibs.core.data.geodata.country;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.data.geodata.continent.data_access.ContinentModel;
import io.github.orionlibs.core.data.geodata.continent.data_access.ContinentsDAO;
import io.github.orionlibs.core.data.geodata.country.data_access.CountriesDAO;
import io.github.orionlibs.core.data.geodata.country.data_access.CountryModel;
import java.util.List;

public class CountryService extends OrionService
{
    public static String getCountryShortNameFromCodeAlpha2(String countryCodeAlpha2)
    {
        CountryModel country = CountriesDAO.getCountryByCodeAlpha2(countryCodeAlpha2);
        return (country != null) ? country.getCountryShortName() : "";
    }


    public static String getCountryShortNameFromCodeAlpha3(String countryCodeAlpha3)
    {
        CountryModel country = CountriesDAO.getCountryByCodeAlpha3(countryCodeAlpha3);
        return (country != null) ? country.getCountryShortName() : "";
    }


    public static String getCountryCodeAlpha2FromShortName(String countryShortName)
    {
        CountryModel country = CountriesDAO.getCountryByShortName(countryShortName);
        return (country != null) ? country.getCountryCodeAlpha2() : "";
    }


    public static String getCountryCodeAlpha3FromShortName(String countryShortName)
    {
        CountryModel country = CountriesDAO.getCountryByShortName(countryShortName);
        return (country != null) ? country.getCountryCodeAlpha3() : "";
    }


    public static String getCountryCodeAlpha2FromLongName(String countryLongName)
    {
        CountryModel country = CountriesDAO.getCountryByLongName(countryLongName);
        return (country != null) ? country.getCountryCodeAlpha2() : "";
    }


    public static String getCountryCodeAlpha3FromName(String countryLongName)
    {
        CountryModel country = CountriesDAO.getCountryByLongName(countryLongName);
        return (country != null) ? country.getCountryCodeAlpha3() : "";
    }


    public static List<CountryModel> getAvailableCountries()
    {
        return CountriesDAO.getCountries();
    }


    public static List<ContinentModel> getAvailableContinents()
    {
        return ContinentsDAO.getContinents();
    }
}