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
import java.util.concurrent.ConcurrentHashMap;

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

    final static WeakPool contextObjects = new WeakPool();

    static SpiceRack root;

    static Map<CoinjemaContext, SpiceRack> contextMap;

    private final Map<Object, Object> depObjects;
    private ContextSource directory;
    private final HashSet<SpiceRack> children;
    Properties coinjemaProperties;
    boolean reconfigurability = false;
    boolean created = false;
    private CoinjemaContext context;

    // Set<WeakReference> contextualized;
    private SpiceRack parent;

    private SpiceRack(final ContextSource directory) {
        context = new CoinjemaContext();
        this.directory = directory;
        depObjects = new ConcurrentHashMap<>(101);
        parent = null;
        contextMap = new HashMap<>();
        created = true;
        root = this;
        contextMap.put(context, this);
        setProperties();
        children = new HashSet<>();
        createChildren();
    }

    private SpiceRack(final CoinjemaContext context,
                      final ContextSource directory, final SpiceRack parent) {
        this.context = context;
        this.directory = directory;
        depObjects = new ConcurrentHashMap<>(101);
        this.parent = parent;
        parent.addChild(this);
        created = true;
        contextMap.put(context, this);
        setProperties();
        children = new HashSet<>();
        createChildren();
    }

    public static SpiceRack getRoot() {
        return root;
    }

    public static SpiceRack getInstance(final CoinjemaContext context) {
        if (context == null) {
            return root;
        }
        return contextMap.get(context);
    }

    public synchronized static void createRootContext() {
        createRootContext(new FileContextSource(System.getProperty("user.dir")));
    }

    public static synchronized void createRootContext(ContextSource directory) {
        new SpiceRack(directory);
    }

    public synchronized static void createContext(
            final String contextName, final ContextSource directory) {
        new SpiceRack(new CoinjemaContext(contextName), directory, root);
    }

    public synchronized static void createContext(
            final String contextName, final ContextSource directory,
            CoinjemaContext parentContext) {
        new SpiceRack(new CoinjemaContext(parentContext, contextName),
                directory, getInstance(parentContext));
    }

    public synchronized static void destroyContext(
            final String contextName) {
        CoinjemaContext context = new CoinjemaContext(contextName);
        SpiceRack rack = getInstance(context);
        rack.clear();
        contextMap.remove(context);
        if (rack == getRoot()) {
            root.clear();
            root = null;
        }
        System.gc();
    }

    private void createChildren() {
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

    boolean isReconfigurable() {
        return reconfigurability;
    }

    void setProperties() {
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

    public void addChild(final SpiceRack child) {
        children.add(child);
    }

    public void removeChild(final SpiceRack child) {
        children.remove(child);
    }

    public Object lookupContext(final String resourceName,
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

    public Object addContext(final Resource res, Class<?> objClass,
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
            Object ret;
            if ((ret = depObjects.get(key)) != null) {
                return ret;
            } else {
                depObjects.put(key, dep);
                return dep;
            }
        }
    }

    SpiceRack getParent() {
        return parent;
    }

    /**
     * @param parent The parent to set.
     */
    public void setParent(final SpiceRack parent) {
        this.parent = parent;
    }

    void clearChild() {
        for (SpiceRack child : children) {
            child.clearChild();
        }
        children.clear();
        depObjects.clear();
        this.parent = null;
    }

    void clear() {
        if (parent != null) {
            parent.removeChild(this);
        }
        clearChild();
    }

    public void refresh() {
        refresh(true);
    }

    public void refresh(boolean redo) {
        List<ContextOriented> l = null;
        if (redo) {
            synchronized (contextObjects) {
                l = new LinkedList<>(contextObjects.map.keySet());
            }
        }
        depObjects.clear();
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
     public CoinjemaContext getContext() {
        return context;
    }

     public void setContext(final CoinjemaContext context) {
        this.context = context;
    }

    /**
     * @return Returns the directory.
     */
     public ContextSource getDirectory() {
        return directory;
    }

    /**
     * @param directory The directory to set.
     */
     public void setDirectory(final ContextSource directory) {
        this.directory = directory;
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
        final Map<String,Object> values = new HashMap<>();
        SpiceRack sub = Recipe.findBaseContext(this.getContext(),
                new CoinjemaContext(contextPath));
        values.put("registry", sub);
        final ResourceNameResolver resolver = new SimpleStringResolver(depName);
        DiscoveredResource disc = RackLoop.limitedLoop(sub, this,
                rack -> Recipe.CONTEXTUALIZER.get().captureDepInContextStack(values, resolver, rack));
        if (disc != null) {
            return disc.dep;
        } else {
            return null;
        }
    }

    public Object getSharedDep(String contextPath) {
        final Map<String,Object> values = new HashMap<>();
        int x = contextPath.lastIndexOf("/");
        String path = null;
        String depName ;
        if (x > -1) {
            path = contextPath.substring(0, x);
            depName = contextPath.substring(x + 1);
        } else {
            depName = contextPath;
        }
        SpiceRack sub = Recipe.findBaseContext(this.getContext(),
                new CoinjemaContext(path));
        values.put("registry", sub);
        final ResourceNameResolver resolver = new SimpleStringResolver(depName);
        DiscoveredResource disc = RackLoop.limitedLoop(sub, this,
                rack -> Recipe.getContextualizer().captureDepInContextStack(values, resolver, rack));
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
