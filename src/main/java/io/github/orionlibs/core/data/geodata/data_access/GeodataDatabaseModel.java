package io.github.orionlibs.core.data.geodata.data_access;

/**
 * model for the Orion database containing database tables and their columns
 * @author dimitrios.efthymiou
 */
public class GeodataDatabaseModel
{
    public static final String tableContinents = "." + "continents";
    public static final String continentCode = "continentCode";
    public static final String continentName = "continentName";
    public static final String tableCountries = "." + "countries";
    public static final String countryCodeAlpha2 = "countryCodeAlpha2";
    public static final String countryCodeAlpha3 = "countryCodeAlpha3";
    public static final String countryCodeNumeric = "countryCodeNumeric";
    public static final String countryShortName = "countryShortName";
    public static final String countryLongName = "countryLongName";
    public static final String tablePostcodes = "." + "postcodes";
    public static final String boroughName = "boroughName";
    public static final String boroughID = "boroughID";
    public static final String city = "city";
    public static final String county = "county";
    public static final String country = "country";
    public static final String postcode = "postcode";
    public static final String postcodeWithoutSpace = "postcodeWithoutSpace";
    public static final String tablePostcodeVotes = "." + "postcode_votes";
    public static final String numberOfVotes = "numberOfVotes";
    public static final String postcodePrefix = "postcodePrefix";
    public static final String emailAddress = "emailAddress";
    public static final String tablePostcodePrefixVotes = "." + "postcode_prefix_votes";
    public static final String tablePostcodeVoters = "." + "postcode_voters";
    public static final String postcodeVoterID = "postcodeVoterID";
}