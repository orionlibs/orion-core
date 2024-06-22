package io.github.orionlibs.core.scripting.shell;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.scripting.shell.tasks.RunCommandTask;
import io.github.orionlibs.core.scripting.shell.tasks.RunShellPipelineTask;
import java.io.File;
import java.util.List;

public class ShellService extends OrionService
{
    public static ShellCommandResult runCommand(ShellCommand command) throws InterruptedException
    {
        return RunCommandTask.run(command);
    }


    public static ShellCommandResult runCommand(ShellCommand command, File workingDirectory) throws InterruptedException
    {
        return RunCommandTask.run(command, workingDirectory);
    }


    public static ShellCommandResult runPipeline(List<ProcessBuilder> processBuilders) throws InterruptedException
    {
        return RunShellPipelineTask.run(processBuilders);
    }
}