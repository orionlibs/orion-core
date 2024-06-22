package io.github.orionlibs.core.web.filter;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.uuid.UUIDSecurityService;

public class JavaThreadIDGenerator extends Orion
{
    static void generateThreadID()
    {
        Thread.currentThread()
                        .setName(UUIDSecurityService.generate2UUIDsWithoutHyphens() + "-" + Long.toString(System.nanoTime()));
    }
}