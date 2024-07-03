package io.github.orionlibs.core.abstraction;

public class OrionCheckedException extends Exception
{
    private static final String DefaultErrorMessage = "There was an error.";
    protected Object exceptionData;


    public OrionCheckedException(Object exceptionData)
    {
        super(DefaultErrorMessage);
        this.exceptionData = exceptionData;
    }


    public OrionCheckedException(String errorMessage)
    {
        super(errorMessage);
    }


    public OrionCheckedException(Object exceptionData, String errorMessage)
    {
        super(errorMessage);
        this.exceptionData = exceptionData;
    }


    public OrionCheckedException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public OrionCheckedException(Object exceptionData, String errorMessage, Object... arguments)
    {
        this(exceptionData, String.format(errorMessage, arguments));
    }


    public OrionCheckedException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public OrionCheckedException(Object exceptionData, Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
        this.exceptionData = exceptionData;
    }


    public OrionCheckedException(Throwable cause)
    {
        super(DefaultErrorMessage, cause);
    }


    public OrionCheckedException(Object exceptionData, Throwable cause)
    {
        super(DefaultErrorMessage, cause);
        this.exceptionData = exceptionData;
    }


    public Object getExceptionData()
    {
        return exceptionData;
    }
}