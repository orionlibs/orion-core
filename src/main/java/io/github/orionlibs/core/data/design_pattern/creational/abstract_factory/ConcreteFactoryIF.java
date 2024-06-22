package io.github.orionlibs.core.data.design_pattern.creational.abstract_factory;

import io.github.orionlibs.core.abstraction.OrionInterface;

public interface ConcreteFactoryIF extends OrionInterface
{
    public abstract ConcreteFactoryIF get();
    //public TYPE1 createType1Object();
    //public TYPE2 createType2Object();
}