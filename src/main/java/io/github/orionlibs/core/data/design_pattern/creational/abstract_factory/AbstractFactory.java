package io.github.orionlibs.core.data.design_pattern.creational.abstract_factory;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.abstraction.OrionEnumeration;
import io.github.orionlibs.core.abstraction.OrionFactoryService;

public abstract class AbstractFactory extends Orion implements OrionFactoryService
{
    public abstract ConcreteFactoryIF buildFactory(OrionEnumeration objectTypeToBuild);
}