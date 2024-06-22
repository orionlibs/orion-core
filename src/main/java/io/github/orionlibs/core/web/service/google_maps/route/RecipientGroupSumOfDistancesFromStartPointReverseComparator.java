package io.github.orionlibs.core.web.service.google_maps.route;

import java.util.Comparator;

public class RecipientGroupSumOfDistancesFromStartPointReverseComparator implements Comparator<RecipientPostcodeGroupByPrefixData>
{
    @Override
    public int compare(RecipientPostcodeGroupByPrefixData x, RecipientPostcodeGroupByPrefixData y)
    {

        if(x.getSumOfDistancesWithinGroup() < y.getSumOfDistancesWithinGroup())
        {
            return 1;
        }
        else if(x.getSumOfDistancesWithinGroup() > y.getSumOfDistancesWithinGroup())
        {
            return -1;
        }
        else
        {
            return 0;
        }

    }
}