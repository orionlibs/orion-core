package io.github.orionlibs.core.reflection.enumeration.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.reflection.classes.ReflectionClassesService;

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