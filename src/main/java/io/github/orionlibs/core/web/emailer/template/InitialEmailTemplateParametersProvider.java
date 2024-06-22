package io.github.orionlibs.core.web.emailer.template;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.CalendarService;
import io.github.orionlibs.core.uuid.UUIDSecurityService;
import java.util.HashMap;
import java.util.Map;

public class InitialEmailTemplateParametersProvider extends Orion
{
    public static Map<String, String> initialiseTemplateParameters()
    {
        return generateInitialTemplateParameters();
    }


    private static Map<String, String> generateInitialTemplateParameters()
    {
        Map<String, String> templateParameters = new HashMap<>();
        templateParameters.put("emailID", UUIDSecurityService.generateUUIDWithoutHyphens());
        templateParameters.put("currentYear", Integer.toString(CalendarService.getCurrentYear()));
        return templateParameters;
    }
}