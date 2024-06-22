package io.github.orionlibs.core.data.source.database.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.data.source.database.Database;
import io.github.orionlibs.core.data.source.database.IgnoreForORM;
import io.github.orionlibs.core.data.source.database.sql.mysql.MySQLQueryBuilderService;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.reflection.variable.access.ReflectionInstanceVariablesAccessService;
import io.github.orionlibs.core.reflection.variable.retrieval.ReflectionInstanceVariablesRetrievalService;
import io.github.orionlibs.core.security.DataSecurityService;
import io.github.orionlibs.core.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SaveModelTask extends Orion
{
    public static int run(OrionModel model, String databaseTable, String databaseName, List<String> columnsToSave)
    {
        Assert.notNull(model, "The given model is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        Assert.notEmpty(columnsToSave, "The given columnsToSave is null/empty.");
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
        mySQLQuery.insertIntoTable(databaseName + databaseTable);
        mySQLQuery.parenthesisedCommaSeparatedColumns(columnsToSave);
        mySQLQuery.valuesOfParenthesisedCommaSeparatedQuestionMarks();
        mySQLQuery.buildParametersArray(modelCopy);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.runSQL(SQL, mySQLQuery.getParameters());
    }


    public static int run(OrionModel model, String databaseTable, String databaseName)
    {
        Assert.notNull(model, "The given model is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
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
        mySQLQuery.insertIntoTable(databaseName + databaseTable);
        List<String> columnsToSave = new ArrayList<>();
        List<Field> privateInstanceVariables = ReflectionInstanceVariablesRetrievalService.getAllPrivateInstanceVariables(modelCopy);

        for(Field field : privateInstanceVariables)
        {
            ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(field);
            IgnoreForORM ignoreForORMAnnotation = field.getAnnotation(IgnoreForORM.class);

            if(ignoreForORMAnnotation == null)
            {
                columnsToSave.add(field.getName());
            }

        }

        mySQLQuery.parenthesisedCommaSeparatedColumns(columnsToSave);
        mySQLQuery.valuesOfParenthesisedCommaSeparatedQuestionMarks();
        mySQLQuery.buildParametersArray(modelCopy);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.runSQL(SQL, mySQLQuery.getParameters());
    }
}