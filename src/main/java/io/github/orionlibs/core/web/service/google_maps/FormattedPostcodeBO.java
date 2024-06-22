package io.github.orionlibs.core.web.service.google_maps;

import com.google.maps.FindPlaceFromTextRequest;
import com.google.maps.FindPlaceFromTextRequest.InputType;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.PlaceDetailsRequest.FieldMask;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.InvalidRequestException;
import com.google.maps.errors.NotFoundException;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.FindPlaceFromText;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResult;
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
public class FormattedPostcodeBO extends AGoogleMapsTask
{
    private String postcode;


    public static FormattedPostcodeBO of(String postcode)
    {
        FormattedPostcodeBO obj = FormattedPostcodeBO.builder()
                        .postcode(postcode)
                        .build();
        obj.initialise();
        return obj;
    }


    private void initialise()
    {
        initialiseRequest();
    }


    @Override
    protected String callAPI()
    {
        FindPlaceFromTextRequest placesAPIRequest = PlacesApi.findPlaceFromText(geoAPIContext, postcode, InputType.TEXT_QUERY);
        String placeIDOfPostcode = "";

        try
        {
            FindPlaceFromText response = placesAPIRequest.await();
            PlacesSearchResult[] results = response.candidates;

            if(results != null && results.length > 0)
            {
                placeIDOfPostcode = results[0].placeId;
            }

        }
        catch(NotFoundException e)
        {
            return (String)repeatAPICall();
        }
        catch(InvalidRequestException e)
        {
            return (String)repeatAPICall();
        }
        catch(ApiException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return (String)repeatAPICall();
        }
        catch(InterruptedException e)
        {
            return (String)repeatAPICall();
        }
        catch(IOException e)
        {
            return (String)repeatAPICall();
        }
        catch(Exception e)
        {
            return (String)repeatAPICall();
        }

        if(placeIDOfPostcode != null && !placeIDOfPostcode.isEmpty())
        {
            PlaceDetailsRequest request = initialisePlaceDetailsRequest(placeIDOfPostcode);

            try
            {
                PlaceDetails response = request.await();
                String postcodeWithoutSpace = postcode.replace(" ", "");

                for(AddressComponent addressComponent : response.addressComponents)
                {
                    String addressComponentWithoutSpace = addressComponent.shortName.replace(" ", "");

                    if(addressComponentWithoutSpace.equalsIgnoreCase(postcodeWithoutSpace))
                    {
                        return addressComponent.shortName;
                    }

                }

            }
            catch(InvalidRequestException e)
            {
                return (String)repeatAPICall();
            }
            catch(ApiException e)
            {
                /*LoggingService.logError(null,
                                null,
                                GoogleMapsErrorType.GoogleMaps.get(),
                                GoogleMapsErrors.ErrorWithGoogleMaps,
                                e);*/
                return (String)repeatAPICall();
            }
            catch(InterruptedException e)
            {
                return (String)repeatAPICall();
            }
            catch(IOException e)
            {
                return (String)repeatAPICall();
            }
            finally
            {
                closeRequest();
            }

        }
        else
        {
            closeRequest();
            return null;
        }

        closeRequest();
        return null;
    }


    public String getFormattedPostcode()
    {
        return callAPI();
    }


    private PlaceDetailsRequest initialisePlaceDetailsRequest(String placeIDOfPostcode)
    {
        PlaceDetailsRequest request = new PlaceDetailsRequest(geoAPIContext);
        request = request.placeId(placeIDOfPostcode);
        request = request.fields(FieldMask.ADDRESS_COMPONENT);
        return request;
    }
}