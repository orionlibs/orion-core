package io.github.orionlibs.orion.core.calendar;

import io.github.orionlibs.orion.core.abstraction.OrionCheckedException;

public class DateTimeRepresentsThePastException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "The datetime represents the past.";


    public DateTimeRepresentsThePastException()
    {
        super(DefaultErrorMessage);
    }


    public DateTimeRepresentsThePastException(String message)
    {
        super(message);
    }


    public DateTimeRepresentsThePastException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public DateTimeRepresentsThePastException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public DateTimeRepresentsThePastException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}