package io.github.orionlibs.core.abstraction;

import io.github.orionlibs.core.configuration.annotations.prop.PropertyDependencyInjectorService;
import io.github.orionlibs.core.logger.ConsoleLoggerService;
import io.github.orionlibs.core.profile.Profile;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public abstract class Orion implements Serializable
{
    public static String systemProfileMode = "localhost";
    public static String domainName = "localhost";


    public Orion()
    {

        if(this instanceof OrionConfigurable)
        {

            try
            {
                new PropertyDependencyInjectorService().injectToFields(this);
            }
            catch(InvocationTargetException e)
            {
                e.printStackTrace();
            }

        }

    }


    public static boolean isTesting()
    {
        return Profile.TestingProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotTesting()
    {
        return !isTesting();
    }


    public static boolean isLocalhost()
    {
        return Profile.LocalhostProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotLocalhost()
    {
        return !isLocalhost();
    }


    public static boolean isDev()
    {
        return Profile.DevProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotDev()
    {
        return !isDev();
    }


    public static boolean isProduction()
    {
        return Profile.ProductionProfile.get().equals(systemProfileMode);
    }


    public static boolean isNotProduction()
    {
        return !isProduction();
    }


    protected static void logToConsole(String message, Object... parameters)
    {
        ConsoleLoggerService.log(message, parameters);
    }


    protected static void logWarningToConsole(String message, Object... parameters)
    {
        ConsoleLoggerService.logWarning(message, parameters);
    }


    protected static void logErrorToConsole(String message, Object... parameters)
    {
        ConsoleLoggerService.logError(message, parameters);
    }


    protected static void logErrorToConsole(Throwable exception, String message, Object... parameters)
    {
        ConsoleLoggerService.logError(exception, message, parameters);
    }
}