package io.github.orionlibs.orion.core.runnable.functions;

@FunctionalInterface
public interface OrionFunctionNx1<T, R> extends OrionFunction
{
    R run(T[] args);
}