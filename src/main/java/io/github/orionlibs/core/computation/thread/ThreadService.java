package io.github.orionlibs.core.computation.thread;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.computation.thread.tasks.GetNumberOfAvailableThreadsTask;

public class ThreadService extends OrionService
{
    public ThreadService()
    {
    }


    public static int getNumberOfAvailableThreads()
    {
        return GetNumberOfAvailableThreadsTask.run();
    }


    public static ThreadFactoryService createNamedThread(String poolName)
    {
        return ThreadFactoryService.of(poolName);
    }
}