package io.github.orionlibs.orion.core.data.source.database.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.abstraction.OrionModel;
import io.github.orionlibs.orion.core.data.source.database.Database;
import io.github.orionlibs.orion.core.data.source.database.sql.mysql.MySQLQueryBuilderService;
import io.github.orionlibs.orion.core.exception.Assert;
import java.util.List;

public class GetAllRowsTask extends Orion
{
    public static List<Object> run(OrionModel emptyModel, String databaseTable, String databaseName)
    {
        Assert.notNull(emptyModel, "The given emptyModel is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(databaseName + databaseTable);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.runSQL(SQL, emptyModel);
    }


    public static List<Object> run(OrionModel emptyModel, String databaseTable, String databaseName, List<String> columnNames)
    {
        Assert.notNull(emptyModel, "The given emptyModel is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectColumns(columnNames);
        mySQLQuery.fromTable(databaseName + databaseTable);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.runSQL(SQL, emptyModel);
    }
}