package io.github.orionlibs.orion.core.scripting.javascript;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.scripting.javascript.tasks.ExecuteAndReturnTask;
import io.github.orionlibs.orion.core.scripting.javascript.tasks.ExecuteTask;
import javax.script.ScriptException;

public class JavaScriptEngineService extends OrionService
{
    public static Object execute(String JavaScriptCodeToExecute) throws ScriptException
    {
        return ExecuteTask.run(JavaScriptCodeToExecute);
    }


    public static Object executeAndReturn(String JavaScriptCodeToExecute, String resultName, Object objectToCastResultTo)
    {
        return ExecuteAndReturnTask.run(JavaScriptCodeToExecute, resultName, objectToCastResultTo);
    }
}