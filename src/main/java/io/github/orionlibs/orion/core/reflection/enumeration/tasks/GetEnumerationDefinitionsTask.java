package io.github.orionlibs.orion.core.reflection.enumeration.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.exception.Assert;

public class GetEnumerationDefinitionsTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes"})
    public static Enum[] run(Class<Enum> enumerationClass)
    {
        Assert.notNull(enumerationClass, "enumerationClass input cannot be null.");
        return enumerationClass.getEnumConstants();
    }
}