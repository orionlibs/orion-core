package io.github.orionlibs.orion.core.web.filter;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.uuid.UUIDSecurityService;

public class JavaThreadIDGenerator extends Orion
{
    static void generateThreadID()
    {
        Thread.currentThread()
                        .setName(UUIDSecurityService.generate2UUIDsWithoutHyphens() + "-" + Long.toString(System.nanoTime()));
    }
}