package io.github.orionlibs.orion.core.web.service.google_maps.route;

import java.util.Comparator;

public class RecipientGroupSumOfDistancesFromStartPointComparator implements Comparator<RecipientPostcodeGroupByPrefixVO>
{
    @Override
    public int compare(RecipientPostcodeGroupByPrefixVO x, RecipientPostcodeGroupByPrefixVO y)
    {

        if(x.getSumOfDistancesWithinGroup() < y.getSumOfDistancesWithinGroup())
        {
            return -1;
        }
        else if(x.getSumOfDistancesWithinGroup() > y.getSumOfDistancesWithinGroup())
        {
            return 1;
        }
        else
        {
            return 0;
        }

    }
}