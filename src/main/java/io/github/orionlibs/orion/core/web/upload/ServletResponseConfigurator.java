package io.github.orionlibs.orion.core.web.upload;

import io.github.orionlibs.orion.core.abstraction.Orion;

class ServletResponseConfigurator extends Orion
{
    static void configure(ServletResponseConfiguration configuration)
    {
        configuration.getResponse().setContentType(configuration.getMIMEType());
        configuration.getResponse().addHeader("Content-Disposition", "attachment; filename=" + configuration.getFileNameForClient());
        configuration.getResponse().setContentLength(configuration.getContentLength());
    }
}