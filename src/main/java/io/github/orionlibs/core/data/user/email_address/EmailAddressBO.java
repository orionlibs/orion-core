package io.github.orionlibs.core.data.user.email_address;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.configuration.ConfigurationService;
import io.github.orionlibs.core.cryptology.encoding.base64.Base64EncodingService;
import io.github.orionlibs.core.exception.Assert;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class EmailAddressBO extends Orion
{
    private String emailAddress;


    public static EmailAddressBO of(String emailAddress)
    {
        return EmailAddressBO.builder().emailAddress(emailAddress).build();
    }


    public String normaliseEmailAddress()
    {
        Assert.notEmpty(emailAddress, "The emailAddress input cannot be null/empty.");
        return emailAddress.trim().toLowerCase();
    }


    public boolean isValidEmailAddress()
    {

        if(emailAddress != null)
        {
            String decodedPattern = Base64EncodingService.decodeBase64ForString(ConfigurationService.getProp("user.management.registration.email.pattern"));
            Pattern pattern = Pattern.compile(decodedPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(emailAddress.trim());
            return matcher.matches();
        }
        else
        {
            return false;
        }

    }
}