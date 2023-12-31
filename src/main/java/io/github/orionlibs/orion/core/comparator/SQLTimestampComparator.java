package io.github.orionlibs.orion.core.comparator;

import io.github.orionlibs.orion.core.abstraction.Orion;
import java.sql.Timestamp;
import java.util.Comparator;

public class SQLTimestampComparator extends Orion implements Comparator<Timestamp>
{
    @Override
    public int compare(Timestamp x, Timestamp y)
    {
        return x.compareTo(y);
    }
}