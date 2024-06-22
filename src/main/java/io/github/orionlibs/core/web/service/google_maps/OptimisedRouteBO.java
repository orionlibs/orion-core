package io.github.orionlibs.core.web.service.google_maps;

import com.google.maps.DirectionsApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.InvalidRequestException;
import com.google.maps.errors.ZeroResultsException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import io.github.orionlibs.core.web.service.google_maps.route.AGoogleMapsTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OptimisedRouteBO extends AGoogleMapsTask// implements OrionConfigurable
{
    private String postcodeStart;
    private String postcodeEnd;
    private List<String> postcodes;
    private DirectionsApiRequest request;
    private List<String> sortedPostcodes;
    //@Prop(key = "google.maps.api.key")
    //private String apiKey;


    public static OptimisedRouteBO of(String postcodeStart, String postcodeEnd, List<String> postcodes)
    {
        OptimisedRouteBO obj = OptimisedRouteBO.builder()
                        .postcodeStart(postcodeStart)
                        .postcodeEnd(postcodeEnd)
                        .postcodes(postcodes)
                        .build();
        obj.initialise();
        return obj;
    }


    private void initialise()
    {
        initialiseRequest();
        List<DirectionsApiRequest.Waypoint> waypoints = new ArrayList<>();
        sortedPostcodes = new ArrayList<>(postcodes);
        Collections.sort(sortedPostcodes);
        sortedPostcodes.forEach(intermediatePostcode -> waypoints.add(new DirectionsApiRequest.Waypoint(intermediatePostcode)));
        request = initialiseDirectionsAPIRequest(waypoints, postcodeStart, postcodeEnd);
    }


    @SuppressWarnings("unchecked")
    @Override
    protected List<String> callAPI()
    {
        List<String> optimumRouteForPostcodes = new ArrayList<>();

        try
        {
            DirectionsResult response = request.await();
            DirectionsRoute[] routes = response.routes;
            int[] waypointOrder = routes[0].waypointOrder;
            optimumRouteForPostcodes.add(postcodeStart);

            for(int i = 0; i < waypointOrder.length; i++)
            {
                optimumRouteForPostcodes.add(sortedPostcodes.get(waypointOrder[i]));
            }

            optimumRouteForPostcodes.add(postcodeEnd);
        }
        catch(ZeroResultsException e)
        {
            optimumRouteForPostcodes.add(postcodeStart);
            optimumRouteForPostcodes.addAll(sortedPostcodes);
            optimumRouteForPostcodes.add(postcodeEnd);
            return optimumRouteForPostcodes;
        }
        catch(InvalidRequestException e)
        {
            return (List<String>)repeatAPICall();
        }
        catch(ApiException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            optimumRouteForPostcodes.add(postcodeStart);
            optimumRouteForPostcodes.addAll(sortedPostcodes);
            optimumRouteForPostcodes.add(postcodeEnd);
            return optimumRouteForPostcodes;
        }
        catch(InterruptedException e)
        {
            return (List<String>)repeatAPICall();
        }
        catch(IOException e)
        {
            return (List<String>)repeatAPICall();
        }
        catch(Exception e)
        {
            return (List<String>)repeatAPICall();
        }
        finally
        {
            closeRequest();
        }

        return optimumRouteForPostcodes;
    }


    public List<String> getRoute()
    {
        return callAPI();
    }


    private DirectionsApiRequest initialiseDirectionsAPIRequest(List<DirectionsApiRequest.Waypoint> waypoints, String postcodeStart, String postcodeEnd)
    {
        DirectionsApiRequest request = new DirectionsApiRequest(geoAPIContext);
        request.alternatives(false);
        //request.custom(postcodeStart, postcodeEnd);
        request.origin(postcodeStart);
        request.destination(postcodeEnd);
        request.optimizeWaypoints(true);
        request.waypoints(waypoints.toArray(new DirectionsApiRequest.Waypoint[0]));
        request.mode(TravelMode.WALKING);
        request.units(Unit.IMPERIAL);
        return request;
    }
}