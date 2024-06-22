package io.github.orionlibs.core.data.source.database;

import io.github.orionlibs.core.abstraction.OrionCheckedException;

public class UnableToShutdownDatabaseConnectionException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Unable to shutdown database connection.";


    public UnableToShutdownDatabaseConnectionException()
    {
        super(DefaultErrorMessage);
    }


    public UnableToShutdownDatabaseConnectionException(String message)
    {
        super(message);
    }


    public UnableToShutdownDatabaseConnectionException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public UnableToShutdownDatabaseConnectionException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public UnableToShutdownDatabaseConnectionException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}