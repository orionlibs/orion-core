package io.github.orionlibs.orion.core.data.design_pattern.creational.abstract_factory;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.abstraction.OrionEnumeration;
import io.github.orionlibs.orion.core.abstraction.OrionFactoryService;

public abstract class AbstractFactory extends Orion implements OrionFactoryService
{
    public abstract ConcreteFactoryIF buildFactory(OrionEnumeration objectTypeToBuild);
}