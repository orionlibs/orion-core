package io.github.orionlibs.orion.core.computation.parallelism;

public class Mutex
{
    public final synchronized void execute(Runnable runnable)
    {
        runnable.run();
    }
}