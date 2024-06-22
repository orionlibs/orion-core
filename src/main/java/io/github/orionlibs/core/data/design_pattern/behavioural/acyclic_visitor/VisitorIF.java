package io.github.orionlibs.core.data.design_pattern.behavioural.acyclic_visitor;

public interface VisitorIF<T> extends BaseVisitorIF
{
    void visit(T objectToVisit);
}
