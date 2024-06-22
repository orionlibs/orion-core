package io.github.orionlibs.core.string.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;

public class PrefixStringTask extends Orion
{
    public static String run(String s, String prefix)
    {
        Assert.notNull(s, "The main string input cannot be null.");
        Assert.notNull(prefix, "The prefix input cannot be null.");
        return prefix + s;
    }
}