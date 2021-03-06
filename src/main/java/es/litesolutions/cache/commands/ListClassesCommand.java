package es.litesolutions.cache.commands;

import com.intersys.objects.CacheException;
import es.litesolutions.cache.db.CacheDb;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

/**
 * ListClasses command: list COS classes from a database
 */
public final class ListClassesCommand
    extends CachedbCommand
{
    public ListClassesCommand(final CacheDb db,
        final Map<String, String> arguments)
    {
        super(db, arguments);
    }

    @Override
    public void execute()
        throws CacheException, SQLException
    {
        final Set<String> set = runner.listClasses(includeSys);
        set.stream().sorted().forEach(System.out::println);
    }
}
