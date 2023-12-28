package io.github.orionlibs.orion.core.runnable.functions;

@FunctionalInterface
public interface OrionFunction1x1<T1, R> extends OrionFunction
{
    R run(T1 t1);
}