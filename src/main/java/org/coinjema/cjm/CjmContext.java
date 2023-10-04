package org.coinjema.cjm;

import java.io.Serial;
import java.io.Serializable;

/**
 * A CjmContext object points to a separate context which may or may not
 * hold individual config information for the system. It is normally used to
 * create a new object in a different context, so that it receives different
 * configuration information than the calling class. A CjmContext is really
 * no more than a String, but is used to avoid namespace problems.
 * CjmContext objects are really just pointers to the actual context - you
 * can easily create objects that point to non-existent contexts. As such, they
 * are cheap objects to create and leave for GC.
 * <p>
 * Context paths are made using strings of the form
 * "parentContext/childContext/grandChildContext".
 *
 * @author mikes
 */
public final class CjmContext implements Serializable {
    static final CjmContext rootContext = new CjmContext();
    @Serial
    private static final long serialVersionUID = 1;
    int reverseIndex = Integer.MIN_VALUE;

    int hash = 7;
    String name;

    public CjmContext() {
        super();
        name = "";
        calcHash();
    }

    public CjmContext(final CjmContext parent, CjmContext child) {
        name = parent.getName() + child.getName();
        calcHash();
        reverseIndex = !parent.getName().isEmpty() ? parent.getName()
                .length() : Integer.MIN_VALUE;
    }

    /**
     * Create a context that is a child of the given parent.
     *
     * @param parent
     * @param subContext
     */
    public CjmContext(final CjmContext parent, final String subContext) {
        this(new StringBuilder(parent.name).append(subContext));
    }

    /**
     * Create a context with the given name.
     *
     * @param n
     */
    public CjmContext(final String n) {
        this(new StringBuilder((n != null) ? n : ""));
    }

    private CjmContext(String n, boolean prevetted) {
        name = n;
        calcHash();
        if (n.length() > 2) {
            reverseIndex = name.lastIndexOf("/", name.length() - 2) + 1;
        } else {
            reverseIndex = -1;
        }
    }

    /**
     * Create a context with the given name.
     */
    private CjmContext(final StringBuilder n) {
        int len = n.length();
        if (len > 0) {
            if (n.charAt(len - 1) != '/') {
                n.append('/');
            }
            if (n.charAt(0) == '/') {
                n.delete(0, 1);
            }
            name = n.toString();
            reverseIndex = name.lastIndexOf("/", name.length() - 2) + 1;
        } else {
            name = "";
        }
        calcHash();
    }

    private void calcHash() {
        hash = name.hashCode() * 3 + 7;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    final public boolean equals(final Object obj) {
        if (obj instanceof CjmContext c) {
            return ((c.name == null) && (name == null))
                    || ((c.name != null) && (c.name.compareTo(name) == 0));
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public CjmContext getParentContext() {
        if (reverseIndex > -1) {
            return new CjmContext(name.substring(0, reverseIndex), true);
        } else if (reverseIndex == -1) {
            return rootContext;
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public String toString() {
        return "Context:" + name + "(" + hashCode() + ")";
    }

}
