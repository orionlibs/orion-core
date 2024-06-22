package io.github.orionlibs.core.data.structure.set.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.data.structure.set.OrionSet;

public class IsSubsetOfTask<T> extends Orion
{
    public static <T> boolean run(OrionSet<T> set1, OrionSet<T> set2)
    {
        OrionSet<T> set2Copy = set2.getCopy();
        set2Copy.retainAll(set1);
        return set2Copy.equals(set1);
    }
}