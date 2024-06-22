package io.github.orionlibs.core.notification.data_access;

import io.github.orionlibs.core.abstraction.OrionDAO;
import io.github.orionlibs.core.data.source.database.Database;
import io.github.orionlibs.core.exception.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationsDAO extends OrionDAO
{
    public static long getNumberOfNotifications(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        NotificationModel model = NotificationModel.builder()
                        .userID(userID)
                        .build();
        return Database.getNumberOfRecords(model,
                        NotificationsDatabaseModel.tableNotifications,
                        Database.databaseName,
                        Arrays.asList(NotificationsDatabaseModel.userID));
    }


    public static long getNumberOfUnseenNotifications(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        NotificationModel model = NotificationModel.builder()
                        .userID(userID)
                        .seen(false)
                        .build();
        return Database.getNumberOfRecords(model,
                        NotificationsDatabaseModel.tableNotifications,
                        Database.databaseName,
                        Arrays.asList(NotificationsDatabaseModel.userID,
                                        NotificationsDatabaseModel.seen));
    }


    public static int save(NotificationModel model)
    {
        return Database.saveModel(model,
                        NotificationsDatabaseModel.tableNotifications,
                        Database.databaseName);
    }


    public static int update(NotificationModel model)
    {
        return Database.updateModel(model,
                        NotificationsDatabaseModel.tableNotifications,
                        Database.databaseName,
                        Arrays.asList(NotificationsDatabaseModel.userID));
    }


    public static int setAsSeen(NotificationModel model)
    {
        Assert.notNull(model, "The given model input cannot be null.");
        model.setSeen(true);
        return update(model);
    }


    public static List<NotificationModel> getNotifications(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        NotificationModel model = NotificationModel.builder()
                        .userID(userID)
                        .build();
        List<NotificationModel> notifications = new ArrayList<>();
        List<Object> temp = Database.getModels(model,
                        NotificationModel.of(),
                        NotificationsDatabaseModel.tableNotifications,
                        Database.databaseName,
                        Arrays.asList(NotificationsDatabaseModel.userID));

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(notification -> notifications.add((NotificationModel)notification));
        }

        return notifications;
    }


    public static int delete(NotificationModel model)
    {
        Assert.notNull(model, "The given model is null.");
        return Database.deleteModel(model,
                        NotificationsDatabaseModel.tableNotifications,
                        Database.databaseName,
                        Arrays.asList(NotificationsDatabaseModel.userID,
                                        NotificationsDatabaseModel.seen,
                                        NotificationsDatabaseModel.message,
                                        NotificationsDatabaseModel.messageSender,
                                        NotificationsDatabaseModel.datetime));
    }


    public static int deleteNotifications(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        NotificationModel model = NotificationModel.builder()
                        .userID(userID)
                        .build();
        return Database.deleteModel(model,
                        NotificationsDatabaseModel.tableNotifications,
                        Database.databaseName,
                        Arrays.asList(NotificationsDatabaseModel.userID));
    }
}