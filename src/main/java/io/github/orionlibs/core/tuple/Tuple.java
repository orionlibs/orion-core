package io.github.orionlibs.core.tuple;

import io.github.orionlibs.core.abstraction.OrionInterface;
import java.util.List;

public interface Tuple extends OrionInterface
{
    Object get(int index);


    Object[] getAsArray();


    List<Object> getAsList();


    boolean isEmpty();
}