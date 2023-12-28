package io.github.orionlibs.orion.core.reflection.enumeration.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.exception.Assert;
import io.github.orionlibs.orion.core.reflection.classes.ReflectionClassesService;

public class InstantiateEnumerationTask extends Orion
{
    @SuppressWarnings(
    {"unchecked", "rawtypes"})
    public static Class<Enum> run(String enumerationPath) throws ClassNotFoundException
    {
        Assert.notEmpty(enumerationPath, "enumerationPath input cannot be null/empty.");
        return (Class<Enum>)ReflectionClassesService.loadClass(enumerationPath);
    }
}