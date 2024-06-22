package io.github.orionlibs.core.data.source.database.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.data.source.database.Database;
import io.github.orionlibs.core.data.source.database.sql.mysql.MySQLQueryBuilderService;
import io.github.orionlibs.core.exception.Assert;

public class TruncateTableTask extends Orion
{
    public static int run(String databaseTable, String databaseName)
    {
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.truncateTable(databaseName + databaseTable);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.runSQL(SQL);
    }
}