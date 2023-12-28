package io.github.orionlibs.orion.core.exception;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.exception.tasks.GetAllErrorMessagesFromTheHierarchyTask;

public class ExceptionService extends OrionService
{
    public static String getAllErrorMessagesFromTheHierarchy(Throwable exception)
    {
        return GetAllErrorMessagesFromTheHierarchyTask.run(exception);
    }
}