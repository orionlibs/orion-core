package io.github.orionlibs.orion.core.web.service.google_maps.route;

import java.util.Comparator;

public class RecipientPostcodeComparator implements Comparator<RecipientPostcodeVO>
{
    @Override
    public int compare(RecipientPostcodeVO x, RecipientPostcodeVO y)
    {
        return x.getPostcode().compareTo(y.getPostcode());
    }
}