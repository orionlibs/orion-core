package io.github.orionlibs.core.notification.data_access;

import io.github.orionlibs.core.abstraction.OrionDAO;
import io.github.orionlibs.core.calendar.datetime.DateTime;
import io.github.orionlibs.core.data.source.database.Database;
import io.github.orionlibs.core.exception.Assert;
import java.util.Arrays;

public class OrionMessagesDAO extends OrionDAO
{
    public static OrionMessageModel getByID(String messageID)
    {
        Assert.notEmpty(messageID, "The given messageID is null/empty.");
        OrionMessageModel model = OrionMessageModel.of(messageID);
        return (OrionMessageModel)Database.getOneModel(model,
                        NotificationsDatabaseModel.tableMessages,
                        Database.messagesDatabaseName,
                        Arrays.asList(NotificationsDatabaseModel.messageID));
    }


    public static OrionMessageModel getByDateTime(DateTime datetime)
    {
        /*Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionContactUsMessageModel model = OrionContactUsMessageModel.builder()
                        .userID(userID).build();
        return (OrionContactUsMessageModel)Database.getOneModel(model,
                        OrionDatabaseModel.tableContactUsMessages,
                        Arrays.asList(OrionDatabaseModel.userID));*/
        return null;
    }


    public static int save(OrionMessageModel model)
    {
        Assert.notNull(model, "The given OrionMessageModel is null.");
        return Database.saveModel(model,
                        NotificationsDatabaseModel.tableMessages,
                        Database.messagesDatabaseName);
    }


    public static int update(OrionMessageModel model)
    {
        Assert.notNull(model, "The given OrionMessageModel is null.");
        return Database.updateModel(model,
                        NotificationsDatabaseModel.tableMessages,
                        Database.messagesDatabaseName,
                        Arrays.asList(NotificationsDatabaseModel.messageID));
    }


    public static int delete(String messageID)
    {
        OrionMessageModel model = OrionMessageModel.of(messageID);
        return Database.deleteModel(model,
                        NotificationsDatabaseModel.tableMessages,
                        Database.messagesDatabaseName,
                        Arrays.asList(NotificationsDatabaseModel.messageID));
    }
}