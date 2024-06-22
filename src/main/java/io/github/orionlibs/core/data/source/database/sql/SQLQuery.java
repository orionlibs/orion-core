package io.github.orionlibs.core.data.source.database.sql;

import io.github.orionlibs.core.abstraction.Orion;

public class SQLQuery extends Orion
{
    private StringBuilder sb;


    public SQLQuery()
    {
        this.sb = new StringBuilder();
    }


    public static SQLQuery of()
    {
        return new SQLQuery();
    }


    public SQLQuery append(String text)
    {
        this.sb.append(text);
        return this;
    }


    public SQLQuery reset()
    {
        this.sb = new StringBuilder();
        return this;
    }


    public String toString()
    {
        return this.sb.toString();
    }
}