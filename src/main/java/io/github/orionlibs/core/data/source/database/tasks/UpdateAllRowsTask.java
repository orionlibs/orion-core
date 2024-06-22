package io.github.orionlibs.core.data.source.database.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.data.source.database.Database;
import io.github.orionlibs.core.data.source.database.sql.mysql.MySQLQueryBuilderService;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.security.DataSecurityService;
import io.github.orionlibs.core.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import java.util.List;

public class UpdateAllRowsTask extends Orion
{
    public static int run(OrionModel model, String databaseTable, String databaseName, List<String> columnsToUpdate)
    {
        Assert.notNull(model, "The given model is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        Assert.notEmpty(columnsToUpdate, "The given columnsToUpdate is null/empty.");
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
        mySQLQuery.updateTable(databaseName + databaseTable);
        mySQLQuery.set();
        mySQLQuery.columnsEqualsQuestionMark(columnsToUpdate);
        mySQLQuery.buildParametersArray(modelCopy);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.runSQL(SQL, mySQLQuery.getParameters());
    }
}