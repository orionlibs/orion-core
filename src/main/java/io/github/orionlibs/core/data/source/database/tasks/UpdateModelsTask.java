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

public class UpdateModelsTask extends Orion
{
    public static int[] run(List<OrionModel> models, String databaseTable, String databaseName, List<String> columnsToUpdate, List<String> columnsForCondition, boolean allowSequentialExecution)
    {
        Assert.notNull(models, "The given models is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        Assert.notEmpty(columnsToUpdate, "The given columnsToUpdate is null/empty.");
        Assert.notEmpty(columnsForCondition, "The given columnsForCondition is null/empty.");

        if(!models.isEmpty())
        {
            String SQL = "";
            List<Object[]> parameters = new ArrayList<>(models.size());
            MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();

            for(OrionModel model : models)
            {
                OrionModel modelCopy = model.getCopy();

                try
                {
                    DataSecurityService.encryptObject(modelCopy);
                }
                catch(NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException e)
                {
                    //
                }

                mySQLQuery.reset();
                mySQLQuery.updateTable(databaseName + databaseTable);
                mySQLQuery.set();
                mySQLQuery.columnsEqualsQuestionMark(columnsToUpdate);
                mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(columnsForCondition);
                mySQLQuery.buildParametersArray(modelCopy);
                SQL += mySQLQuery.semicolon().toString();
                parameters.add(mySQLQuery.getParameters());
            }

            return Database.runSQLBatch(SQL, parameters, allowSequentialExecution);
        }

        return null;
    }


    public static int[] run(List<OrionModel> models, String databaseTable, String databaseName, List<String> columnsForCondition, boolean allowSequentialExecution)
    {
        Assert.notNull(models, "The given models is null.");
        Assert.notEmpty(databaseTable, "The given databaseTable is null/empty.");
        Assert.notEmpty(columnsForCondition, "The given columnsForCondition is null/empty.");

        if(!models.isEmpty())
        {
            String SQL = "";
            List<Object[]> parameters = new ArrayList<>(models.size());
            MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();

            for(OrionModel model : models)
            {
                OrionModel modelCopy = model.getCopy();

                try
                {
                    DataSecurityService.encryptObject(modelCopy);
                }
                catch(NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException e)
                {
                    //
                }

                mySQLQuery.reset();
                mySQLQuery.updateTable(databaseName + databaseTable);
                mySQLQuery.set();
                List<String> columnsToUpdate = new ArrayList<>();
                List<Field> privateInstanceVariables = ReflectionInstanceVariablesRetrievalService.getAllPrivateInstanceVariables(modelCopy);

                for(Field field : privateInstanceVariables)
                {
                    ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(field);
                    IgnoreForORM ignoreForORMAnnotation = field.getAnnotation(IgnoreForORM.class);

                    if(ignoreForORMAnnotation == null)
                    {
                        columnsToUpdate.add(field.getName());
                    }

                }

                mySQLQuery.columnsEqualsQuestionMark(columnsToUpdate);
                mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(columnsForCondition);
                mySQLQuery.buildParametersArray(modelCopy);
                SQL += mySQLQuery.semicolon().toString();
                parameters.add(mySQLQuery.getParameters());
            }

            return Database.runSQLBatch(SQL, parameters, allowSequentialExecution);
        }

        return null;
    }
}