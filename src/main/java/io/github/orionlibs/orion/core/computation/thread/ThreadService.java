package io.github.orionlibs.orion.core.computation.thread;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.computation.thread.tasks.GetNumberOfAvailableThreadsTask;

public class ThreadService extends OrionService
{
    public ThreadService()
    {
    }


    public static int getNumberOfAvailableThreads()
    {
        return GetNumberOfAvailableThreadsTask.run();
    }


    public static int getNumberOfAvailableThreads(final Class<?> classWithConcurrencyAnnotation)
    {
        return GetNumberOfAvailableThreadsTask.run(classWithConcurrencyAnnotation);
    }


    public static ThreadFactoryService createNamedThread(String poolName)
    {
        return ThreadFactoryService.of(poolName);
    }
}