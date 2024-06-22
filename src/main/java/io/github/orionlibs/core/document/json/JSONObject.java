package io.github.orionlibs.core.document.json;

import io.github.orionlibs.core.abstraction.Orion;
import java.util.Map;

public class JSONObject extends Orion
{
    private Map<?, ?> JSONMapData;
    private String JSONStringData;


    public JSONObject()
    {
    }


    public JSONObject(Map<?, ?> JSONMapData, String JSONStringData)
    {
        this.JSONMapData = JSONMapData;
        this.JSONStringData = JSONStringData;
    }


    public Map<?, ?> getJSONMapData()
    {
        return JSONMapData;
    }


    public String getJSONStringData()
    {
        return JSONStringData;
    }
}