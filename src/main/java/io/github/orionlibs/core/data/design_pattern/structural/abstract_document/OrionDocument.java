package io.github.orionlibs.core.data.design_pattern.structural.abstract_document;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public interface OrionDocument
{
    void put(String key, Object value);


    Object get(String key);


    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
