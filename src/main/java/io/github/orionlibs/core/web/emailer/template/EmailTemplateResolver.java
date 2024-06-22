package io.github.orionlibs.core.web.emailer.template;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.configuration.ConfigurationService;
import io.github.orionlibs.core.cryptology.encoding.base64.Base64EncodingService;

public class EmailTemplateResolver extends Orion
{
    public static String resolve(String velocityTemplateID)
    {
        String emailTemplate = ConfigurationService.getProp(velocityTemplateID);
        return Base64EncodingService.decodeBase64ForString(emailTemplate);
    }
}