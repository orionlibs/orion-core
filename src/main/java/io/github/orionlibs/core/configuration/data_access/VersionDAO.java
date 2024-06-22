package io.github.orionlibs.core.configuration.data_access;

import io.github.orionlibs.core.abstraction.OrionDAO;
import io.github.orionlibs.core.data.source.database.Database;

public class VersionDAO extends OrionDAO
{
    public static long getNumberOfVersions()
    {
        return Database.getNumberOfRecords(ConfigurationDatabaseModel.tableVersion, Database.configurationDatabaseName);
    }
}