package io.github.orionlibs.core.data.source.database.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.data.source.database.Database;
import io.github.orionlibs.core.data.source.database.sql.mysql.MySQLQueryBuilderService;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.security.DataSecurityService;
import io.github.orionlibs.core.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import java.util.List;

public class GetNumberOfRecordsTask extends Orion
{
    public static long run(String databaseTable, String databaseName)
    {
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectColumn("COUNT(1)");
        mySQLQuery.fromTable(databaseName + databaseTable);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, Long.valueOf(0), mySQLQuery.getParameters());

        if(temp != null && !temp.isEmpty())
        {
            return (long)temp.get(0);
        }

        return 0L;
    }


    public static long run(String SQL, Object[] parameters)
    {
        Assert.notEmpty(SQL, "The given SQL is null/empty.");
        Assert.notEmpty(parameters, "The given parameters is null/empty.");
        List<Object> temp = Database.runSQL(SQL, Long.valueOf(0), parameters);

        if(temp != null && !temp.isEmpty())
        {
            return (long)temp.get(0);
        }

        return 0L;
    }


    public static long run(OrionModel model, String databaseTable, String databaseName, List<String> columnsForCondition)
    {
        Assert.notNull(model, "The given model is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        Assert.notEmpty(columnsForCondition, "The given columnsForCondition is null/empty.");
        OrionModel modelCopy = model.getCopy();

        try
        {
            DataSecurityService.encryptObject(modelCopy);
        }
        catch(NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException e)
        {
            //
        }

        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectColumn("COUNT(*)");
        mySQLQuery.fromTable(databaseName + databaseTable);
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(columnsForCondition);
        mySQLQuery.buildParametersArray(modelCopy);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, Long.valueOf(0), mySQLQuery.getParameters());

        if(temp != null && !temp.isEmpty())
        {
            return (long)temp.get(0);
        }

        return 0L;
    }
}