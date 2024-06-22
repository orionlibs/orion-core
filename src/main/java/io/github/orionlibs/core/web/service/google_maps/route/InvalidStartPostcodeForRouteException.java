package io.github.orionlibs.core.web.service.google_maps.route;

import io.github.orionlibs.core.abstraction.OrionCheckedException;

public class InvalidStartPostcodeForRouteException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Invalid postcode as a starting point of a route.";


    public InvalidStartPostcodeForRouteException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidStartPostcodeForRouteException(String message)
    {
        super(message);
    }


    public InvalidStartPostcodeForRouteException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidStartPostcodeForRouteException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidStartPostcodeForRouteException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}