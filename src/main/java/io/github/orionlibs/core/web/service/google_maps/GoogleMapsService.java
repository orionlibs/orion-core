package io.github.orionlibs.core.web.service.google_maps;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.web.service.google_maps.model.DistanceAndTravelDurationModel;
import io.github.orionlibs.core.web.service.google_maps.route.OptimumRouteData;
import io.github.orionlibs.core.web.service.google_maps.route.OptimumRouteService;
import java.util.List;

public class GoogleMapsService extends OrionService
{
    public static DistanceAndTravelDurationModel getDistanceAndTravelDuration(String postcode1, String postcode2)
    {
        return TravelDetailsBO.of(postcode1, postcode2).getTravelDetails();
    }


    public static String getFormattedPostcode(String postcode)
    {
        return FormattedPostcodeBO.of(postcode).getFormattedPostcode();
    }


    public static OptimumRouteData getOptimumRouteForPostcodes(String startPostcode, String endPostcode, List<String> waypoints)
    {
        return OptimumRouteService.getOptimumRouteForPostcodes(startPostcode, endPostcode, waypoints);
    }


    public static List<String> getOptimumRouteForPostcodes(List<String> postcodes)
    {
        String startPostcode = postcodes.get(0);
        String endPostcode = postcodes.get(postcodes.size() - 1);
        List<String> waypoints = postcodes.subList(1, postcodes.size() - 1);
        return getOptimumRouteForPostcodes(startPostcode, endPostcode, waypoints).getRoute();
    }
}