package org.coinjema.context;

import org.coinjema.context.source.ContextSource;

import java.util.function.Supplier;

/**
 * Contains static methods for initializing Coinjema with context locations.  Also contains methods for destroying
 * contexts and refreshing the cached dependencies.  Warning: don't expect refresh to magically reconfigure all your
 * objects already in-memory.
 *
 * @author mikes
 */
public class ContextFactory {

    public static ScopedValue<CjmContext> CONTEXT = ScopedValue.newInstance();
    public static CjmContext ROOT_CONTEXT = new CjmContext("");


    private ContextFactory() {
        super();
    }



    /**
     * Creates the root context using the default working directory as the base context location. (ie System.getProperty("user.dir")).
     * Until the root context is created, Coinjema will not function properly.
     *
     * @throws Exception
     */
    public static void createRootContext() throws Exception {
        SpiceRack.createRootContext();
    }

    public static <T> T withContext(CjmContext newContext, Supplier<T> func) {
        try {
            return ScopedValue.callWhere(CONTEXT,newContext, () -> func.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates the root context using the given ContextSource object.  Until the root context is created, Coinjema will
     * not function properly.
     *
     * @param directory
     * @throws Exception
     */
    public static void createRootContext(ContextSource directory) throws Exception {
        SpiceRack.createRootContext(directory);
    }

    /**
     * Create a new child context of the root context with the given name and ContextSource.  Use this to add a
     * set of contexts from a location not found under the root context by default.
     *
     * @param contextName
     * @param directory
     * @throws Exception
     */
    public static void createContext(String contextName, ContextSource directory) throws Exception {
        SpiceRack.createContext(contextName, directory);
    }

    /**
     * Create a new child context of the root context with the given name and ContextSource.  Use this to add a
     * set of contexts from a location not found under the root context by default.
     *
     * @param contextName
     * @param directory
     * @throws Exception
     */
    public static void createContext(String contextName, ContextSource directory, CjmContext parentContext) throws Exception {
        SpiceRack.createContext(contextName, directory, parentContext);
    }

    /**
     * Removes all the information stored for a context and prevents its further usage.
     *
     * @param contextName
     */
    public static void destroyContext(String contextName) {
        SpiceRack.destroyContext(contextName);
    }

    /**
     * Clears all stored information for the given context and all its children.  This will not result in all your
     * in-memory objects being reconfigured, but any newly created objects will result in the config scripts being
     * re-evaluated.
     *
     * @param context
     */
    public static void refresh(CjmContext context) {
        SpiceRack.getInstance(context).refresh();
    }

    public static Registry getRegistry(String contextName) {
        return SpiceRack.getInstance(new CjmContext(contextName));
    }

    public static CjmContext getContext() {
        return CONTEXT.orElse(ROOT_CONTEXT);
    }
}
