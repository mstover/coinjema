/*
 * Created on Mar 13, 2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.coinjema.context;

import org.coinjema.context.source.ContextSource;
import org.coinjema.context.source.FileContextSource;
import org.coinjema.context.source.MetaType;
import org.coinjema.context.source.Resource;

import java.io.File;
import java.util.*;

/**
 * The SpiceRack keeps a single registry-like tree for the entire JVM, though
 * different contexts can be accessed by creating new Spiceracks and passing in
 * a context name.
 *
 * @author mstover
 * <p>
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
final public class SpiceRack implements Registry {

    public static WeakPool contextObjects = new WeakPool();

    static SpiceRack root;

    static Map<CoinjemaContext, SpiceRack> contextMap;

    Map<Object, Object> depObjects;

    CoinjemaContext context;

    SpiceRack parent;

    ContextSource directory;

    HashSet<SpiceRack> children;

    Properties coinjemaProperties;

    boolean reconfigurability = false;

    // Set<WeakReference> contextualized;

    boolean created = false;

    private SpiceRack(final ContextSource directory) {
        context = new CoinjemaContext();
        this.directory = directory;
        depObjects = Collections.synchronizedMap(new HashMap<Object, Object>(
                101));
        parent = null;
        contextMap = new HashMap<CoinjemaContext, SpiceRack>();
        created = true;
        root = this;
        contextMap.put(context, this);
        setProperties();
        createChildren();
    }

    private SpiceRack(final CoinjemaContext context,
                      final ContextSource directory, final SpiceRack parent) {
        this.context = context;
        this.directory = directory;
        depObjects = Collections.synchronizedMap(new HashMap<Object, Object>(
                101));
        this.parent = parent;
        parent.addChild(this);
        created = true;
        contextMap.put(context, this);
        setProperties();
        createChildren();
    }

    final static String contextAddSlash(final CoinjemaContext context) {
        if (context == null || context.name == null) {
            return "";
        }
        return context.name;
    }

    final public static SpiceRack getRoot() {
        return root;
    }

    final public static SpiceRack getInstance(final CoinjemaContext context) {
        if (context == null) {
            return root;
        }
        return contextMap.get(context);
    }

    final public synchronized static void createRootContext() throws Exception {
        createRootContext(new FileContextSource(System.getProperty("user.dir")));
    }

    public static synchronized void createRootContext(ContextSource directory)
            throws Exception {
        new SpiceRack(directory);
    }

    final public synchronized static void createContext(
            final String contextName, final ContextSource directory) {
        new SpiceRack(new CoinjemaContext(contextName), directory, root);
    }

    final public synchronized static void createContext(
            final String contextName, final ContextSource directory,
            CoinjemaContext parentContext) {
        new SpiceRack(new CoinjemaContext(parentContext, contextName),
                directory, getInstance(parentContext));
    }

    final public synchronized static void destroyContext(
            final String contextName) {
        SpiceRack rack = getInstance(new CoinjemaContext(contextName));
        rack.clear();
        contextMap.remove(contextName);
        if (rack == getRoot()) {
            root.clear();
            root = null;
        }
        System.gc();
    }

    final private void createChildren() {
        children = new HashSet<SpiceRack>();
        for (ContextSource subContext : directory.getSubContexts()) {
            if ((!coinjemaProperties.containsKey("includeDirs") || subContext
                    .getName().matches(
                            coinjemaProperties.getProperty("includeDirs")))
                    && (!coinjemaProperties.containsKey("excludeDirs") || !subContext
                    .getName().matches(
                            coinjemaProperties
                                    .getProperty("excludeDirs")))) {
                new SpiceRack(
                        new CoinjemaContext(context, subContext.getName()),
                        subContext, this);
            }
        }
    }

    final boolean isReconfigurable() {
        return reconfigurability;
    }

    final void setProperties() {
        coinjemaProperties = new Properties();
        if (getParent() != null) {
            coinjemaProperties.putAll(getParent().coinjemaProperties);
        }
        DiscoveredResource temp = ScriptEvaluator.evaluate("coinjema",
                getDirectory(), null);
        if (temp != null && temp.dep != null) {
            coinjemaProperties.putAll((Properties) temp.dep);
        }
        reconfigurability = coinjemaProperties.getProperty("reconfigurable",
                "false").equals("true");
    }

    final public void addChild(final SpiceRack child) {
        children.add(child);
    }

    final public void removeChild(final SpiceRack child) {
        children.remove(child);
    }

    final public Object lookupContext(final String resourceName,
                                      Class<?> objClass, Object obj) {
        Object dep = depObjects.get(resourceName);
        if (dep != null) {
            return dep;
        }
        if (objClass != null) {
            dep = depObjects.get(new ClassKey(objClass, resourceName));
            if (dep != null) {
                return dep;
            }
        }
        if (obj != null) {
            return depObjects.get(new ObjectKey(obj, resourceName));
        }
        return null;
    }

    public MetaType getScope(final String resourceName, Class<?> objClass,
                             Object obj) {
        Object dep = depObjects.get(resourceName);
        if (dep != null) {
            return MetaType.global;
        }
        if (objClass != null) {
            dep = depObjects.get(new ClassKey(objClass, resourceName));
            if (dep != null) {
                return MetaType.perClass;
            }
        }
        if (obj != null) {
            dep = depObjects.get(new ObjectKey(obj, resourceName));
            if (dep != null) {
                return MetaType.perObj;
            }
        }
        return null;
    }

    final public Object addContext(final Resource res, Class<?> objClass,
                                   Object obj, final Object dep) {
        if (res == null) {
            return dep; // safeDepStorage(dep, res.getName());
        } else if (res.getMetaTypes().contains(MetaType.perClass)
                && objClass != null) {
            Object key = new ClassKey(objClass, res.getName());
            return safeDepStorage(dep, key);
        } else if (res.getMetaTypes().contains(MetaType.perObj) && obj != null) {
            Object key = new ObjectKey(obj, res.getName());
            return safeDepStorage(dep, key);
        } else if (res.getMetaTypes().contains(MetaType.global)) {
            return safeDepStorage(dep, res.getName());
        } else {
            return dep;
        }
    }

    private Object safeDepStorage(final Object dep, Object key) {
        synchronized (depObjects) {
            Object ret = null;
            if ((ret = depObjects.get(key)) != null) {
                return ret;
            } else {
                depObjects.put(key, dep);
                return dep;
            }
        }
    }

    final protected SpiceRack getParent() {
        return parent;
    }

    /**
     * @param parent The parent to set.
     */
    final public void setParent(final SpiceRack parent) {
        this.parent = parent;
    }

    final protected void clearChild() {
        for (SpiceRack child : children) {
            child.clearChild();
        }
        children.clear();
        depObjects = Collections.synchronizedMap(new HashMap<Object, Object>(
                101));
        this.parent = null;
    }

    final protected void clear() {
        if (parent != null) {
            parent.removeChild(this);
        }
        clearChild();
    }

    final public void refresh() {
        refresh(true);
    }

    final public void refresh(boolean redo) {
        List<ContextOriented> l = null;
        if (redo) {
            synchronized (contextObjects) {
                l = new LinkedList<ContextOriented>(contextObjects.map.keySet());
            }
        }
        depObjects = Collections.synchronizedMap(new HashMap<Object, Object>(
                101));
        for (SpiceRack child : children) {
            child.refresh(false);
        }
        if (redo) {
            for (ContextOriented co : l) {
                Recipe.contextualizeWithoutSave(co, co.getCoinjemaContext(),
                        null);
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.coinjema.context.NamedContext#getContext()
     */
    final public CoinjemaContext getContext() {
        return context;
    }

    final public void setContext(final CoinjemaContext context) {
        this.context = context;
    }

    /**
     * @return Returns the directory.
     */
    final public ContextSource getDirectory() {
        return directory;
    }

    /**
     * @param directory The directory to set.
     */
    final public void setDirectory(final ContextSource directory) {
        this.directory = directory;
    }

    Object getSharedDependency(String label, Map<String, Object> values) {
        Object dep;
        dep = lookupContext(label, null, null);
        if (dep == null) {
            dep = ScriptEvaluator.evaluate(label, this.getDirectory(), values);
        }
        return dep;
    }

    public File getContextRoot() {
        ContextSource source = root.getDirectory();
        if (source instanceof FileContextSource) {
            return ((FileContextSource) source).getRootDirectory();
        } else {
            return new File(System.getProperty("user.dir"));
        }
    }

    public Object getSharedDep(String contextPath, String depName) {
        final Map values = new HashMap();
        SpiceRack sub = Recipe.findBaseContext(this.getContext(),
                new CoinjemaContext(contextPath));
        values.put("registry", sub);
        final ResourceNameResolver resolver = new SimpleStringResolver(depName);
        DiscoveredResource disc = RackLoop.limitedLoop(sub, this,
                rack -> Recipe.captureDepInContextStack(values, resolver, rack));
        if (disc != null) {
            return disc.dep;
        } else {
            return null;
        }
    }

    public Object getSharedDep(String contextPath) {
        final Map values = new HashMap();
        int x = contextPath.lastIndexOf("/");
        String path = null;
        String depName = null;
        if (x > -1) {
            path = contextPath.substring(0, x);
            depName = contextPath.substring(x + 1);
        } else {
            path = null;
            depName = contextPath;
        }
        SpiceRack sub = Recipe.findBaseContext(this.getContext(),
                new CoinjemaContext(path));
        values.put("registry", sub);
        final ResourceNameResolver resolver = new SimpleStringResolver(depName);
        DiscoveredResource disc = RackLoop.limitedLoop(sub, this,
                rack -> Recipe.captureDepInContextStack(values, resolver, rack));
        if (disc != null) {
            return disc.dep;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "(" + getContext() + ")";
    }

}
