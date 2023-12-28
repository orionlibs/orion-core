package io.github.orionlibs.orion.core.configuration.data_access;

import io.github.orionlibs.orion.core.abstraction.OrionDAO;
import io.github.orionlibs.orion.core.data.source.database.Database;

public class VersionDAO extends OrionDAO
{
    public static long getNumberOfVersions()
    {
        return Database.getNumberOfRecords(ConfigurationDatabaseModel.tableVersion, Database.configurationDatabaseName);
    }
}