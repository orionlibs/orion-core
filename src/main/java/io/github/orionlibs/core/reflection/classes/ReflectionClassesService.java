package io.github.orionlibs.core.reflection.classes;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.exception.InaccessibleException;
import io.github.orionlibs.core.reflection.classes.tasks.InstantiateClassTask;
import io.github.orionlibs.core.reflection.classes.tasks.LoadClassTask;
import java.lang.reflect.InvocationTargetException;

public class ReflectionClassesService extends OrionService
{
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClassTypeOfGenericType(T object)
    {
        Assert.notNull(object, "object input cannot be null.");
        return (Class<T>)object.getClass().getComponentType();
    }


    public static Class<?> loadClass(String className) throws ClassNotFoundException
    {
        return LoadClassTask.run(className);
    }


    public static Object instantiateClass(Class<?> classToInstantiate, Class<?>[] constructorArgumentTypes, Object[] constructorArguments) throws InvocationTargetException, InaccessibleException
    {
        return InstantiateClassTask.run(classToInstantiate, constructorArgumentTypes, constructorArguments);
    }


    public static Object instantiateClass(String classToInstantiateString, Class<?>[] constructorArgumentTypes, Object[] constructorArguments) throws InvocationTargetException, InaccessibleException
    {
        return InstantiateClassTask.run(classToInstantiateString, constructorArgumentTypes, constructorArguments);
    }
}