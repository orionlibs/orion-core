package io.github.orionlibs.core.web.filter.init;

import io.github.orionlibs.core.abstraction.Orion;
import java.util.logging.Logger;
import jakarta.servlet.ServletContext;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

@Order(value = 1)
public class OrionInitialiser extends Orion implements WebApplicationInitializer
{
    private static final transient Logger LOG = Logger.getLogger(OrionInitialiser.class.getName());
    public static boolean orionInitialised = false;


    @Override
    public void onStartup(ServletContext servletContext)
    {

        if(!OrionInitialiser.orionInitialised)
        {
            LOG.info("Orion is initialising...");
            OrionInitialiser.orionInitialised = true;
        }

    }
}