package io.github.orionlibs.core.web.service.google_maps;

import com.google.maps.DirectionsApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.InvalidRequestException;
import com.google.maps.errors.NotFoundException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import io.github.orionlibs.core.web.service.google_maps.model.DistanceAndTravelDurationModel;
import io.github.orionlibs.core.web.service.google_maps.route.AGoogleMapsTask;
import java.io.IOException;
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
public class TravelDetailsBO extends AGoogleMapsTask
{
    private String postcode1;
    private String postcode2;
    private DirectionsApiRequest request;


    public static TravelDetailsBO of(String postcode1, String postcode2)
    {
        TravelDetailsBO obj = TravelDetailsBO.builder()
                        .postcode1(postcode1)
                        .postcode2(postcode2)
                        .build();
        obj.initialise();
        return obj;
    }


    private void initialise()
    {
        initialiseRequest();
        setRequest(initialiseDirectionsAPIRequest());
    }


    @Override
    protected DirectionsRoute[] callAPI()
    {

        try
        {
            DirectionsResult response = request.await();
            return response.routes;
        }
        catch(NotFoundException e)
        {
            return (DirectionsRoute[])repeatAPICall();
        }
        catch(InvalidRequestException e)
        {
            return (DirectionsRoute[])repeatAPICall();
        }
        catch(ApiException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return (DirectionsRoute[])repeatAPICall();
        }
        catch(InterruptedException e)
        {
            return (DirectionsRoute[])repeatAPICall();
        }
        catch(IOException e)
        {
            return (DirectionsRoute[])repeatAPICall();
        }
        catch(Exception e)
        {
            return (DirectionsRoute[])repeatAPICall();
        }
        finally
        {
            closeRequest();
        }

    }


    public DistanceAndTravelDurationModel getTravelDetails()
    {
        float distance = Float.MAX_VALUE;
        long travelDurationInSeconds = 0L;
        DirectionsRoute[] routes = callAPI();

        if(routes != null && routes.length > 0)
        {
            DirectionsLeg legOfJourney = routes[0].legs[0];
            float distanceTemp = legOfJourney.distance.inMeters / 1609.0f;

            if(distanceTemp < distance)
            {
                distance = distanceTemp;
                travelDurationInSeconds = legOfJourney.duration.inSeconds;
            }

        }

        return DistanceAndTravelDurationModel.builder()
                        .distance(distance)
                        .travelDurationInSeconds(travelDurationInSeconds)
                        .build();
    }


    private DirectionsApiRequest initialiseDirectionsAPIRequest()
    {
        DirectionsApiRequest request = new DirectionsApiRequest(geoAPIContext);
        request.alternatives(true);
        request.destination(postcode2);
        request.optimizeWaypoints(false);
        request.origin(postcode1);
        request.mode(TravelMode.DRIVING);
        request.units(Unit.IMPERIAL);
        return request;
    }
}