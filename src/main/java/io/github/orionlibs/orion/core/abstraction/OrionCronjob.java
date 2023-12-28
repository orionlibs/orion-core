package io.github.orionlibs.orion.core.abstraction;

public interface OrionCronjob extends OrionInterface
{
    public void runCronjobUsingCronExpression();
}