package io.github.orionlibs.core.data.user.address;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.web.service.google_maps.GoogleMapsService;
import java.util.regex.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class PostcodeBO extends Orion
{
    private String postcode;
    private String formattedPostcode;


    public static PostcodeBO of()
    {
        return PostcodeBO.builder().build();
    }


    public static PostcodeBO of(String postcode)
    {
        return PostcodeBO.builder().postcode(postcode).build();
    }


    public boolean isValidPostcode()
    {
        return postcode != null && !postcode.isEmpty();
    }


    public String getPostcodePrefixWithoutUsingGoogleMaps(String postcodeToCheck)
    {
        String[] tokens = postcodeToCheck.split("\\s+");

        if(tokens != null && tokens.length > 0)
        {
            return tokens[0];
        }
        else
        {
            return null;
        }

    }


    public boolean isValidPostcode(String postcodePattern)
    {
        return Pattern.compile(postcodePattern).matcher(postcode).matches();
    }


    public String getPostcodePrefix()
    {
        formattedPostcode = GoogleMapsService.getFormattedPostcode(postcode);

        if(formattedPostcode != null && !formattedPostcode.isEmpty())
        {
            return getPostcodePrefixWithoutUsingGoogleMaps(formattedPostcode);
        }
        else
        {
            return null;
        }

    }
}