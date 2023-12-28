package io.github.orionlibs.orion.core.web.service.google_maps;

import io.github.orionlibs.orion.core.abstraction.OrionErrorMessages;

public class GoogleMapsErrors extends OrionErrorMessages
{
    public static final String ErrorWithGoogleMaps = "Problem with Google Maps";
    public static final String PaymentNotCompletedErrorForOrderID = "Someone tried to set the payment as successful before payment was completed for orderID = ";
    public static final String ErrorWithPaymentCancellationWithStripe = "Problem with payment cancellation with Stripe";
}