package io.github.orionlibs.orion.core.abstraction;

import io.github.orionlibs.orion.core.logger.ConsoleLoggerService;
import java.io.Serializable;

public interface OrionInterface extends Serializable
{
    default void logInfo(String message, Object... parameters)
    {
        ConsoleLoggerService.log(message, parameters);
    }


    default void logAWarning(String message, Object... parameters)
    {
        ConsoleLoggerService.logWarning(message, parameters);
    }


    default void logAnError(String message, Object... parameters)
    {
        ConsoleLoggerService.logError(message, parameters);
    }
}