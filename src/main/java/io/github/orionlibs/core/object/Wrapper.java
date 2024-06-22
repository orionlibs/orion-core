package io.github.orionlibs.core.object;

import io.github.orionlibs.core.abstraction.Orion;

public class Wrapper extends Orion
{
    private Object object;


    public Wrapper(Object object)
    {
        this.object = object;
    }


    public static Wrapper of(Object object)
    {
        return new Wrapper(object);
    }


    public Object getObject()
    {
        return this.object;
    }
}