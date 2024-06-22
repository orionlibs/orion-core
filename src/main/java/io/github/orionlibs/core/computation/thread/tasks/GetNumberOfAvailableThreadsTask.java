package io.github.orionlibs.core.computation.thread.tasks;

public class GetNumberOfAvailableThreadsTask
{
    public static int run()
    {
        return Runtime.getRuntime().availableProcessors();
    }
}