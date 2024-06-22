package io.github.orionlibs.core.web.service.google_maps.route;

import java.util.Comparator;

public class RecipientPostcodeComparator implements Comparator<RecipientPostcodeData>
{
    @Override
    public int compare(RecipientPostcodeData x, RecipientPostcodeData y)
    {
        return x.getPostcode().compareTo(y.getPostcode());
    }
}