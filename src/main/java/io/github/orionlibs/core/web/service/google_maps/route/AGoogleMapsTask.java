package io.github.orionlibs.core.web.service.google_maps.route;

import com.google.maps.GeoApiContext;
import com.google.maps.GeoApiContext.Builder;
import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.configuration.InMemoryConfigurationService;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class AGoogleMapsTask extends Orion
{
    protected GeoApiContext geoAPIContext;
    private int numberOfRetries = 1;


    protected void initialiseRequest()
    {
        Builder requestBuilder = new GeoApiContext.Builder();
        requestBuilder.apiKey(InMemoryConfigurationService.getProp("google.maps.api.key"));
        requestBuilder.connectTimeout(15, TimeUnit.SECONDS);
        requestBuilder.readTimeout(15, TimeUnit.SECONDS);
        requestBuilder.maxRetries(2);
        this.geoAPIContext = requestBuilder.build();
    }


    protected void closeRequest()
    {

        try
        {

            if(geoAPIContext != null)
            {
                geoAPIContext.close();
                geoAPIContext.shutdown();
            }

            geoAPIContext = null;
        }
        catch(IOException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
        }

    }


    abstract protected Object callAPI();


    protected Object repeatAPICall()
    {
        closeRequest();

        if(numberOfRetries == 1)
        {

            try
            {
                Thread.sleep(2000);
                numberOfRetries = 0;
                return callAPI();
            }
            catch(InterruptedException e)
            {
                return null;
            }

        }
        else
        {
            return null;
        }

    }
}