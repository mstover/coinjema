package org.coinjema.context;

import org.coinjema.context.source.ContextSource;

import java.util.LinkedList;

/**
 * Contains static methods for initializing Coinjema with context locations.  Also contains methods for destroying
 * contexts and refreshing the cached dependencies.  Warning: don't expect refresh to magically reconfigure all your
 * objects already in-memory.
 *
 * @author mikes
 */
public class ContextFactory {
    static ThreadLocal<LinkedList<CoinjemaContext>> tracker = new ThreadLocal<LinkedList<CoinjemaContext>>() {
        public LinkedList<CoinjemaContext> initialValue() {
            return new LinkedList<CoinjemaContext>();
        }
    };


    private ContextFactory() {
        super();
    }

    /**
     * For direct and quick control over a thread's current context, call this method to push a
     * context onto its stack.  Any objects created in this thread after pushing a context will be
     * created in that context.  You must remove the context when you are done via popContext();
     *
     * @param cc
     */
    public static void pushContext(CoinjemaContext cc) {
        tracker.get().addFirst(cc);
    }

    /**
     * Remove the top context from the context stack.  DO NOT call this unless you added a context
     * manually via pushContext(CoinjemaContext).
     */
    public static void popContext() {
        tracker.get().removeFirst();
    }

    public static CoinjemaContext peek() {
        return tracker.get().peek();
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
    public static void createContext(String contextName, ContextSource directory, CoinjemaContext parentContext) throws Exception {
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
    public static void refresh(CoinjemaContext context) {
        SpiceRack.getInstance(context).refresh();
    }

    public static Registry getRegistry(String contextName) {
        return SpiceRack.getInstance(new CoinjemaContext(contextName));
    }

    public static TempCoinjemaContext pushContext(ContextOriented coObj) {
        CoinjemaContext coinjemaContext = coObj.getCoinjemaContext();
        var tmpContext = new TempCoinjemaContext(coinjemaContext);
        pushContext(coinjemaContext);
        return tmpContext;
    }
}
