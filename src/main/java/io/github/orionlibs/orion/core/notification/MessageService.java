package io.github.orionlibs.orion.core.notification;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.calendar.CalendarService;
import io.github.orionlibs.orion.core.notification.data_access.OrionMessageModel;
import io.github.orionlibs.orion.core.notification.data_access.OrionMessagesDAO;
import io.github.orionlibs.orion.core.uuid.UUIDSecurityService;

public class MessageService extends OrionService
{
    public static OrionMessageModel getMessageByID(String messageID)
    {
        return OrionMessagesDAO.getByID(messageID);
    }


    public static OrionMessageModel saveMessage(OrionMessageModel model)
    {

        if(model != null)
        {

            if(model.getMessageID() == null || model.getMessageID().isEmpty())
            {
                model.setMessageID(UUIDSecurityService.generateUUIDWithoutHyphens());
            }

            model.setMessageDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp());
            model.setHasBeenRead(false);
            OrionMessagesDAO.save(model);
        }

        return model;
    }
}