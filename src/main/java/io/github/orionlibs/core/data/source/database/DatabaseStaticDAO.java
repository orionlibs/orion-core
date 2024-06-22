package io.github.orionlibs.core.data.source.database;

import io.github.orionlibs.core.abstraction.Orion;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional("PlatformTransactionManager")
public class DatabaseStaticDAO extends Orion
{
    public void runStaticSQL(String SQLCode, JdbcTemplate JDBC)
    {

        try
        {
            JDBC.execute(SQLCode);
        }
        catch(DataAccessException e)
        {
            logErrorToConsole(e.getMessage());
            throw e;
        }

    }
}