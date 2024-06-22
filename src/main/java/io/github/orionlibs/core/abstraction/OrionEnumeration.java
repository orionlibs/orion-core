package io.github.orionlibs.core.abstraction;

public interface OrionEnumeration extends OrionInterface
{
    String get();


    boolean is(OrionEnumeration other);


    boolean isNot(OrionEnumeration other);
}