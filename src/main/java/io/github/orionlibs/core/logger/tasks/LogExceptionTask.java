package io.github.orionlibs.core.logger.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.SQLTimestamp;
import io.github.orionlibs.core.configuration.ConfigurationService;
import io.github.orionlibs.core.exception.ExceptionService;
import io.github.orionlibs.core.logger.data_access.OrionErrorLogModel;
import io.github.orionlibs.core.logger.data_access.OrionErrorLogsDAO;
import io.github.orionlibs.core.runnable.OrionJob;

public class LogExceptionTask extends Orion implements OrionJob
{
    private SQLTimestamp currentDateTime;
    private String IPAddress;
    private String userID;
    private String errorType;
    private String errorMessage;
    private Throwable exception;
    private Object[] parameters;


    public LogExceptionTask(SQLTimestamp currentDateTime, String IPAddress, String userID, String errorType, String errorMessage, Throwable exception, Object... parameters)
    {
        this.currentDateTime = currentDateTime;
        this.IPAddress = IPAddress;
        this.userID = userID;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
        this.exception = exception;
        this.parameters = parameters;
    }


    public void run()
    {
        boolean logToTomcat = ConfigurationService.getBooleanProp("error.logging.to.tomcat.enable");
        boolean logToDatabase = ConfigurationService.getBooleanProp("error.logging.to.database.enable");

        if(logToTomcat || logToDatabase)
        {
            String errorMessageTemp = "";

            if(parameters != null && parameters.length > 0)
            {
                errorMessageTemp += String.format(errorMessage, parameters);
            }
            else
            {
                errorMessageTemp += errorMessage;
            }

            if(exception != null)
            {
                errorMessageTemp += ExceptionService.getAllErrorMessagesFromTheHierarchy(exception);
            }

            if(logToTomcat)
            {
                logErrorToConsole(errorMessageTemp);
            }

            if(logToDatabase)
            {
                OrionErrorLogModel model = OrionErrorLogModel.builder()
                                .operationID(Thread.currentThread().getName())
                                .userID(userID)
                                .IPAddress(IPAddress)
                                .errorMessage(errorMessageTemp)
                                .errorType(errorType)
                                .logDate(currentDateTime.toLocalDateTime().toLocalDate().toString())
                                .logDateTime(currentDateTime)
                                .comment("")
                                .lastUpdateDateTime(currentDateTime)
                                .isBeingInvestigated(false)
                                .hasBeingInvestigated(false)
                                .isBeingIgnored(false)
                                .build();
                OrionErrorLogsDAO.save(model);
            }

        }

    }
}