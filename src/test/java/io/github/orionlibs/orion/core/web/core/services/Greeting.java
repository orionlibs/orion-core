package io.github.orionlibs.orion.core.web.core.services;

public class Greeting
{
    private long id;
    private String content;


    public Greeting()
    {
    }


    public Greeting(long id, String content)
    {
        this.id = id;
        this.content = content;
    }


    public long getId()
    {
        return this.id;
    }


    public void setId(long id)
    {
        this.id = id;
    }


    public String getContent()
    {
        return this.content;
    }


    public void setContent(String content)
    {
        this.content = content;
    }
}