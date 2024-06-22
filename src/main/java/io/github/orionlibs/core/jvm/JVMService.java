package io.github.orionlibs.core.jvm;

import io.github.orionlibs.core.abstraction.OrionService;
import java.lang.management.ManagementFactory;

public class JVMService extends OrionService
{
    public static long getUsedHeapMemoryInBytes()
    {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
    }


    public static long getCommittedHeapMemoryInBytes()
    {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getCommitted();
    }


    public static long getMaximumHeapMemoryInBytes()
    {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax();
    }
}