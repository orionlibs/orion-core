package io.github.orionlibs.core.exception;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.exception.tasks.GetAllErrorMessagesFromTheHierarchyTask;

public class ExceptionService extends OrionService
{
    public static String getAllErrorMessagesFromTheHierarchy(Throwable exception)
    {
        return GetAllErrorMessagesFromTheHierarchyTask.run(exception);
    }
}