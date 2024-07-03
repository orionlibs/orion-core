package io.github.orionlibs.core.abstraction;

public class OrionUncheckedException extends RuntimeException
{
    private static final String DefaultErrorMessage = "There was an error.";
    protected Object exceptionData;


    public OrionUncheckedException(Object exceptionData)
    {
        super(DefaultErrorMessage);
        this.exceptionData = exceptionData;
    }


    public OrionUncheckedException(String errorMessage)
    {
        super(errorMessage);
    }


    public OrionUncheckedException(Object exceptionData, String errorMessage)
    {
        super(errorMessage);
        this.exceptionData = exceptionData;
    }


    public OrionUncheckedException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public OrionUncheckedException(Object exceptionData, String errorMessage, Object... arguments)
    {
        this(exceptionData, String.format(errorMessage, arguments));
    }


    public OrionUncheckedException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public OrionUncheckedException(Object exceptionData, Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
        this.exceptionData = exceptionData;
    }


    public OrionUncheckedException(Throwable cause)
    {
        super(DefaultErrorMessage, cause);
    }


    public OrionUncheckedException(Object exceptionData, Throwable cause)
    {
        super(DefaultErrorMessage, cause);
        this.exceptionData = exceptionData;
    }


    public Object getExceptionData()
    {
        return exceptionData;
    }
}