package es.litesolutions.cache.commands;

import es.litesolutions.cache.CacheDb;
import es.litesolutions.cache.CacheRunner;
import es.litesolutions.cache.util.Argument;

import java.util.Map;

public abstract class CachedbCommand
{
    protected final CacheDb cacheDb;
    protected final CacheRunner runner;
    protected final Map<String, String> arguments;

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    protected CachedbCommand(final CacheDb cacheDb,
        final Map<String, String> arguments)
    {
        this.cacheDb = cacheDb;
        runner = new CacheRunner(cacheDb);
        this.arguments = arguments;
    }

    public abstract void execute()
        throws Exception;

    protected final String getArgument(final String name)
    {
        return Argument.read(name, arguments);
    }

    protected final String getArgumentOrDefault(final String name,
        final String defaultValue)
    {
        return Argument.readOrDefault(name, arguments, defaultValue);
    }
}