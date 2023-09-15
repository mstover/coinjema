/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/*
 * This class appeared originally in the Apache JMeter project, and is used in Coinjema
 * with modifications and improvements.  Although the Coinjema project is Public Domain
 * software, please be aware of the source files with an Apache origin.
 */

package org.coinjema.collections;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * This class is used to create a tree structure of objects.  Each element in
 * the tree is also a key to the next node down in the tree.  It provides many
 * ways to add objects and branches, as well as many ways to retrieve.
 * <p>
 * HashTree implements the Map interface for convenience reasons.  The main
 * difference between a Map and a HashTree is that the HashTree organizes the
 * data into a recursive tree structure, and provides the means to manipulate
 * that structure.
 * <p>
 * Of special interest is the {@link #traverse(HashTreeTraverser)} method,
 * which provides an expedient way to traverse any HashTree by implementing the
 * {@link HashTreeTraverser} interface in order to perform some operation on
 * the tree, or to extract information from the tree.
 *
 * @author Michael Stover (mstover1 at apache.org)
 * @version $Revision: 1.6 $ Updated on: $Date: 2006/05/22 18:28:15 $
 * @see HashTreeTraverser
 * @see SearchByClass
 */
public class HashTree<T> implements Serializable, Map<T, HashTree<T>> {
    private final static long serialVersionUID = 1;
    protected Map<T, HashTree<T>> data;

    /**
     * Creates an empty new HashTree.
     */
    public HashTree() {
        data = new HashMap<T, HashTree<T>>();
    }

    /**
     * Creates a new HashTree and adds the given object as a top-level node.
     *
     * @param key
     */
    public HashTree(T key) {
        data = new HashMap<T, HashTree<T>>();
        data.put(key, new HashTree<T>());
    }

    /**
     * Creates a new HashTree and adds all the objects in the given collection
     * as top-level nodes in the tree.
     *
     * @param keys a collection of objects to be added to the created HashTree.
     */
    public HashTree(Collection<? extends T> keys) {
        data = new HashMap<T, HashTree<T>>();
        for (T key : keys) {
            data.put(key, new HashTree<T>());
        }
    }

    /**
     * Creates a new HashTree and adds all the objects in the given array as
     * top-level nodes in the tree.
     */
    public HashTree(T[] keys) {
        data = new HashMap<T, HashTree<T>>();
        for (T key : keys) {
            data.put(key, new HashTree<T>());
        }
    }

    /**
     * Implemented as required by the Map interface, but is not very useful
     * here. All 'values' in a HashTree are HashTree's themselves.
     *
     * @param value Object to be tested as a value.
     * @return True if the HashTree contains the value, false otherwise.
     * @see java.util.Map#containsValue(Object)
     */
    public boolean containsValue(Object value) {
        return data.containsValue(value);
    }

    /**
     * Clears the HashTree of all contents.
     *
     * @see java.util.Map#clear()
     */
    public void clear() {
        data.clear();
    }

    /**
     * Adds a key as a node at the current level and then adds the given
     * HashTree to that new node.
     *
     * @param key     key to create in this tree
     * @param subTree sub tree to add to the node created for the first
     *                argument.
     */
    public void add(T key, HashTree<? extends T> subTree) {
        add(key);
        getTree(key).add(subTree);
    }

    /**
     * Adds all the nodes and branches of the given tree to this tree.  Is like
     * merging two trees.  Duplicates are ignored.
     *
     * @param newTree
     */
    public void add(HashTree<? extends T> newTree) {
        for (T item : newTree.list()) {
            add(item);
            getTree(item).add(newTree.getTree(item));
        }
    }

    /**
     * If the HashTree contains the given object as a key at the top level,
     * then a true result is returned, otherwise false.
     *
     * @param o Object to be tested as a key.
     * @return True if the HashTree contains the key, false otherwise.
     * @see java.util.Map#containsKey(Object)
     */
    public boolean containsKey(Object o) {
        return data.containsKey(o);
    }

    /**
     * If the HashTree is empty, true is returned, false otherwise.
     *
     * @return True if HashTree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Sets a key and it's value in the HashTree.  It actually sets up a key,
     * and then creates a node for the key and sets the value to the new node,
     * as a key.  Any previous nodes that existed under the given key are lost.
     *
     * @param key   key to be set up
     * @param value value to be set up as a key in the secondary node
     */
    public void set(T key, T value) {
        data.put(key, createNewTree(value));
    }

    /**
     * Sets a key into the current tree and assigns it a HashTree as its
     * subtree.  Any previous entries under the given key are removed.
     *
     * @param key key to be set up
     * @param t   HashTree that the key maps to
     */
    public void set(T key, HashTree<T> t) {
        data.put(key, t);
    }

    public void set(T[] path, HashTree<T> t) {
        set(Arrays.asList(path), t);
    }

    /**
     * Sets a key and it's values in the HashTree.  It sets up a key in the
     * current node, and then creates a node for that key, and sets all the
     * values in the array as keys in the new node.  Any keys previously held
     * under the given key are lost.
     *
     * @param key    Key to be set up
     * @param values Array of objects to be added as keys in the secondary node
     */
    public void set(T key, T[] values) {
        data.put(key, createNewTree(Arrays.asList(values)));
    }

    /**
     * Sets a key and its values in the HashTree.  It sets up a key in the
     * current node, and then creates a node for that key, and set all the
     * values in the array as keys in the new node.  Any keys previously held
     * under the given key are removed.
     *
     * @param key    key to be set up
     * @param values Collection of objects to be added as keys in the secondary
     *               node
     */
    public void set(T key, Collection<? extends T> values) {
        data.put(key, createNewTree(values));
    }

    /**
     * Sets a series of keys into the HashTree.  It sets up the first object in
     * the key array as a key in the current node, recurses into the next
     * HashTree node through that key and adds the second object in the array.
     * Continues recursing in this manner until the end of the first array is
     * reached, at which point all the values of the second array are set as
     * keys to the bottom-most node.  All previous keys of that bottom-most
     * node are removed.
     *
     * @param treePath array of keys to put into HashTree
     * @param values   array of values to be added as keys to bottom-most node
     */
    public void set(T[] treePath, T[] values) {
        if (treePath != null && values != null) {
            set(Arrays.asList(treePath), Arrays.asList(values));
        }
    }

    /**
     * Sets a series of keys into the HashTree.  It sets up the first object in
     * the key array as a key in the current node, recurses into the next
     * HashTree node through that key and adds the second object in the array.
     * Continues recursing in this manner until the end of the first array is
     * reached, at which point all the values of the Collection of values are
     * set as keys to the bottom-most node.  Any keys previously held by the
     * bottom-most node are lost.
     *
     * @param treePath array of keys to put into HashTree
     * @param values   Collection of values to be added as keys to bottom-most
     *                 node
     */
    public void set(T[] treePath, Collection<? extends T> values) {
        if (treePath != null) {
            set(Arrays.asList(treePath), values);
        }
    }

    /**
     * Sets a series of keys into the HashTree.  It sets up the first object in
     * the key list as a key in the current node, recurses into the next
     * HashTree node through that key and adds the second object in the list.
     * Continues recursing in this manner until the end of the first list is
     * reached, at which point all the values of the array of values are set as
     * keys to the bottom-most node.  Any previously existing keys of that
     * bottom node are removed.
     *
     * @param treePath collection of keys to put into HashTree
     * @param values   array of values to be added as keys to bottom-most node
     */
    public void set(Collection<? extends T> treePath, T[] values) {
        HashTree<T> tree = addTreePath(treePath);
        tree.set(Arrays.asList(values));
    }

    /**
     * Sets the nodes of the current tree to be the objects of the given
     * collection. Any nodes previously in the tree are removed.
     *
     * @param values Collection of objects to set as nodes.
     */
    public void set(Collection<? extends T> values) {
        clear();
        this.add(values);
    }

    /**
     * Sets a series of keys into the HashTree.  It sets up the first object in
     * the key list as a key in the current node, recurses into the next
     * HashTree node through that key and adds the second object in the list.
     * Continues recursing in this manner until the end of the first list is
     * reached, at which point all the values of the Collection of values are
     * set as keys to the bottom-most node.  Any previously existing keys of
     * that bottom node are lost.
     *
     * @param treePath list of keys to put into HashTree
     * @param values   collection of values to be added as keys to bottom-most
     *                 node
     */
    public void set(Collection<? extends T> treePath, Collection<? extends T> values) {
        HashTree<T> tree = addTreePath(treePath);
        tree.set(values);
    }

    public void set(Collection<? extends T> treePath, HashTree<T> t) {
        HashTree<T> tree = addTreePath(treePath);
        tree.set(t);
    }

    public void set(HashTree<T> t) {
        this.data = t.data;
    }

    /**
     * Adds an key into the HashTree at the current level.
     *
     * @param key key to be added to HashTree
     */
    public HashTree<T> add(T key) {
        if (!data.containsKey(key)) {
            HashTree<T> newTree = createNewTree();
            data.put(key, newTree);
            return newTree;
        } else {
            return getTree(key);
        }
    }

    /**
     * Adds all the given objects as nodes at the current level.
     *
     * @param keys Array of Keys to be added to HashTree.
     */
    public void add(T[] keys) {
        for (T x : keys) {
            add(x);
        }
    }

    /**
     * Adds a bunch of keys into the HashTree at the current level.
     *
     * @param keys Collection of Keys to be added to HashTree.
     */
    public void add(Collection<? extends T> keys) {
        for (T it : keys) {
            add(it);
        }
    }

    /**
     * Adds a key and it's value in the HashTree.  The first argument becomes a
     * node at the current level, and the second argument becomes a node of it.
     *
     * @param key   key to be added
     * @param value value to be added as a key in the secondary node
     */
    public HashTree<T> add(T key, T value) {
        add(key);
        return getTree(key).add(value);
    }

    /**
     * Adds a key and it's values in the HashTree.  The first argument becomes
     * a node at the current level, and adds all the values in the array to
     * the new node.
     *
     * @param key    key to be added
     * @param values array of objects to be added as keys in the secondary node
     */
    public void add(T key, T[] values) {
        add(key);
        getTree(key).add(values);
    }

    /**
     * Adds a key as a node at the current level and then adds all the objects
     * in the second argument as nodes of the new node.
     *
     * @param key    key to be added
     * @param values Collection of objects to be added as keys in the secondary
     *               node
     */
    public void add(T key, Collection<? extends T> values) {
        add(key);
        getTree(key).add(values);
    }

    /**
     * Adds a series of nodes into the HashTree using the given path.  The
     * first argument is an array that represents a path to a specific node in
     * the tree.  If the path doesn't already exist, it is created (the objects
     * are added along the way).  At the path, all the objects in the second
     * argument are added as nodes.
     *
     * @param treePath an array of objects representing a path
     * @param values   array of values to be added as keys to bottom-most node
     */
    public void add(T[] treePath, T[] values) {
        if (treePath != null) {
            add(Arrays.asList(treePath), Arrays.asList(values));
        }
    }

    /**
     * Adds a series of nodes into the HashTree using the given path.  The
     * first argument is an array that represents a path to a specific node in
     * the tree.  If the path doesn't already exist, it is created (the objects
     * are added along the way).  At the path, all the objects in the second
     * argument are added as nodes.
     *
     * @param treePath an array of objects representing a path
     * @param values   collection of values to be added as keys to bottom-most
     *                 node
     */
    public void add(T[] treePath, Collection<? extends T> values) {
        if (treePath != null) {
            add(Arrays.asList(treePath), values);
        }
    }

    public HashTree<T> add(T[] treePath, T value) {
        return add(Arrays.asList(treePath), value);
    }

    /**
     * Adds a series of nodes into the HashTree using the given path.  The
     * first argument is a List that represents a path to a specific node in
     * the tree.  If the path doesn't already exist, it is created (the objects
     * are added along the way).  At the path, all the objects in the second
     * argument are added as nodes.
     *
     * @param treePath a list of objects representing a path
     * @param values   array of values to be added as keys to bottom-most node
     */
    public void add(Collection<? extends T> treePath, T[] values) {
        HashTree<T> tree = addTreePath(treePath);
        tree.add(Arrays.asList(values));
    }

    /**
     * Adds a series of nodes into the HashTree using the given path.  The
     * first argument is a List that represents a path to a specific node in
     * the tree.  If the path doesn't already exist, it is created (the objects
     * are added along the way).  At the path, the object in the second
     * argument is added as a node.
     *
     * @param treePath a list of objects representing a path
     * @param value    Object to add as a node to bottom-most node
     */
    public HashTree<T> add(Collection<? extends T> treePath, T value) {
        HashTree<T> tree = addTreePath(treePath);
        return tree.add(value);
    }

    public void add(T[] treePath, HashTree<? extends T> subTree) {
        HashTree<T> tree = addTreePath(Arrays.asList(treePath));
        tree.add(subTree);
    }

    /**
     * Adds a series of nodes into the HashTree using the given path.  The
     * first argument is a SortedSet that represents a path to a specific node
     * in the tree.  If the path doesn't already exist, it is created (the
     * objects are added along the way).  At the path, all the objects in the
     * second argument are added as nodes.
     *
     * @param treePath a SortedSet of objects representing a path
     * @param values   Collection of values to be added as keys to bottom-most
     *                 node
     */
    public void add(Collection<? extends T> treePath, Collection<? extends T> values) {
        HashTree<T> tree = addTreePath(treePath);
        tree.add(values);
    }

    protected HashTree<T> addTreePath(Collection<? extends T> treePath) {
        HashTree<T> tree = this;
        for (T temp : treePath) {
            tree.add(temp);
            tree = tree.getTree(temp);
        }
        return tree;
    }

    /**
     * Gets the HashTree mapped to the given key.
     *
     * @param key Key used to find appropriate HashTree()
     */
    public HashTree<T> getTree(Object key) {
        return data.get(key);
    }

    /**
     * Returns the first object of the tree associated with the given key.  This
     * is a convenience method that essentially accomplishes the same as getArray()[0].
     * Returns null if the key is not found or the end tree has zero elements.
     *
     * @param key
     * @return
     */
    public T getObject(T key) {
        try {
            return list(key).iterator().next();
        } catch (Exception e) {
            return null;
        }
    }

    public T getObject() {
        try {
            return list().iterator().next();
        } catch (Exception e) {
            return null;
        }
    }

    public T getObject(T... keys) {
        try {
            return list(keys).iterator().next();
        } catch (Exception e) {
            return null;
        }
    }

    public T getObject(Collection<?> keys) {
        try {
            return list(keys).iterator().next();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Gets the HashTree object mapped to the last key in the array by
     * recursing through the HashTree structure one key at a time.
     *
     * @param treePath array of keys.
     * @return HashTree at the end of the recursion.
     */
    public HashTree<T> getTree(Object[] treePath) {
        if (treePath != null) {
            return getTree(Arrays.asList(treePath));
        } else {
            return this;
        }
    }

    /**
     * Create a clone of this HashTree.  This is not a deep clone (ie, the
     * contents of the tree are not cloned).
     *
     * @see java.lang.Object#clone()
     */
    public HashTree<T> clone() {
        HashTree<T> newTree = new HashTree<T>();
        cloneTree(newTree);
        return newTree;
    }

    protected void cloneTree(HashTree<T> newTree) {
        for (T key : list()) {
            newTree.set(key, getTree(key).clone());
        }
    }

    /**
     * Creates a new tree.  This method exists to allow inheriting classes to
     * generate the appropriate types of nodes.  For instance, when a node is
     * added, it's value is a HashTree. Rather than directly calling the
     * HashTree() constructor, the createNewTree() method is called.
     * Inheriting classes should override these methods and create the
     * appropriate subclass of HashTree.
     *
     * @return HashTree
     */
    protected HashTree<T> createNewTree() {
        return new HashTree<T>();
    }

    /**
     * Creates a new tree.  This method exists to allow inheriting classes to
     * generate the appropriate types of nodes.  For instance, when a node is
     * added, it's value is a HashTree. Rather than directly calling the
     * HashTree() constructor, the createNewTree() method is called.
     * Inheriting classes should override these methods and create the
     * appropriate subclass of HashTree.
     *
     * @return HashTree
     */
    protected HashTree<T> createNewTree(T key) {
        return new HashTree<T>(key);
    }

    /**
     * Creates a new tree.  This method exists to allow inheriting classes to
     * generate the appropriate types of nodes.  For instance, when a node is
     * added, it's value is a HashTree. Rather than directly calling the
     * HashTree() constructor, the createNewTree() method is called.
     * Inheriting classes should override these methods and create the
     * appropriate subclass of HashTree.
     *
     * @return HashTree
     */
    protected HashTree<T> createNewTree(Collection<? extends T> values) {
        return new HashTree<T>(values);
    }

    /**
     * Gets the HashTree object mapped to the last key in the SortedSet by
     * recursing through the HashTree structure one key at a time.
     *
     * @param treePath Collection of keys
     * @return HashTree at the end of the recursion
     */
    public HashTree<T> getTree(Collection<?> treePath) {
        return getTreePath(treePath);
    }

    /**
     * Gets a Collection of all keys in the current HashTree node.  If the
     * HashTree represented a file system, this would be like getting a
     * collection of all the files in the current folder.
     *
     * @return Set of all keys in this HashTree
     */
    public Collection<T> list() {
        return data.keySet();
    }

    /**
     * Gets a Set of all keys in the HashTree mapped to the given key of the
     * current HashTree object (in other words, one level down.  If the HashTree
     * represented a file system, this would like getting a list of all files in
     * a sub-directory (of the current directory) specified by the key argument.
     *
     * @param key key used to find HashTree to get list of
     * @return Set of all keys in found HashTree.
     */
    public Collection<T> list(Object key) {
        HashTree<T> temp = data.get(key);
        if (temp != null) {
            return temp.list();
        } else {
            return new LinkedList<T>();
        }
    }

    /**
     * Removes the entire branch specified by the given key.
     *
     * @see java.util.Map#remove(Object)
     */
    public HashTree<T> remove(Object key) {
        return data.remove(key);
    }

    public HashTree<T> remove(Object[] path) {
        Object[] shortened = new Object[path.length - 1];
        System.arraycopy(path, 0, shortened, 0, path.length - 1);
        Object rem = path[path.length - 1];
        HashTree temp = getTree(shortened);
        if (temp != null) return temp.remove(rem);
        else return null;
    }

    /**
     * Recurses down into the HashTree stucture using each subsequent key in the
     * array of keys, and returns the Set of keys of the HashTree object at the
     * end of the recursion.  If the HashTree represented a file system, this
     * would be like getting a list of all the files in a directory specified by
     * the treePath, relative from the current directory.
     *
     * @param treePath Array of keys used to recurse into HashTree structure
     * @return Set of all keys found in end HashTree
     */
    public Collection<T> list(Object[] treePath) {
        if (treePath != null) {
            return list(Arrays.asList(treePath));
        } else {
            return list();
        }
    }

    /**
     * Recurses down into the HashTree stucture using each subsequent key in
     * the List of keys, and returns the Set of keys of the HashTree object at
     * the end of the recursion.  If the HashTree represented a file system,
     * this would be like getting a list of all the files in a directory
     * specified by the treePath, relative from the current directory.
     *
     * @param treePath List of keys used to recurse into HashTree structure
     * @return Set of all keys found in end HashTree
     */
    public Collection<T> list(Collection<?> treePath) {
        HashTree<T> tree = getTreePath(treePath);
        if (tree != null)
            return tree.list();
        return new LinkedList<T>();
    }

    /**
     * Finds the given current key, and replaces it with the given new key.
     * Any tree structure found under the original key is moved to the new key.
     */
    public void replaceKey(Object currentKey, T newKey) {
        HashTree<T> tree = getTree(currentKey);
        data.remove(currentKey);
        data.put(newKey, tree);
    }

    @Override
    public HashTree<T> replace(T key, HashTree<T> value) {
        return data.replace(key,value);
    }

    protected HashTree<T> getTreePath(Collection<?> treePath) {
        HashTree<T> tree = this;
        for (Object temp : treePath) {
            if (tree == null) return null;
            tree = tree.getTree(temp);
        }
        return tree;
    }

    /**
     * Returns a hashcode for this HashTree.
     *
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return data.hashCode() * 7;
    }

    /**
     * Compares all objects in the tree and verifies that the two trees contain
     * the same objects at the same tree levels.  Returns true if they do,
     * false otherwise.
     *
     * @param o Object to be compared against
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object o) {
        if (!(o instanceof HashTree)) return false;
        HashTree oo = (HashTree) o;
        if (oo.size() != this.size()) return false;
        return data.equals(oo.data);
    }

    /**
     * Searches the HashTree structure for the given key.  If it finds the key,
     * it returns the HashTree mapped to the key.  If it finds nothing, it
     * returns null.
     *
     * @param key Key to search for
     * @return HashTree mapped to key, if found, otherwise <code>null</code>
     */
    public HashTree<T> search(Object key) {
        HashTree<T> result = getTree(key);
        if (result != null) {
            return result;
        }
        TreeSearcher<T> searcher = new TreeSearcher<T>(key);
        try {
            traverse(searcher);
        } catch (Exception e) {
            //do nothing - means object is found
        }
        return searcher.getResult();
    }

    /**
     * Method readObject.
     */
    void readObject(ObjectInputStream ois)
            throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
    }

    void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
    }

    /**
     * Returns the number of top-level entries in the HashTree.
     *
     * @see java.util.Map#size()
     */
    public int size() {
        return data.size();
    }

    /**
     * Allows any implementation of the HashTreeTraverser interface to
     * easily traverse (depth-first) all the nodes of the HashTree.  The
     * Traverser implementation will be given notification of each node visited.
     *
     * @see HashTreeTraverser
     */
    public void traverse(HashTreeTraverser<T> visitor) {
        for (T item : list()) {
            visitor.addNode(item, getTree(item));
            getTree(item).traverseInto(visitor);
        }
    }

    /**
     * The recursive method that accomplishes the tree-traversal and performs
     * the callbacks to the HashTreeTraverser.
     */
    private void traverseInto(HashTreeTraverser<T> visitor) {

        if (list().size() == 0) {
            visitor.processPath();
        } else {
            for (T item : list()) {
                visitor.addNode(item, getTree(item));
                if (getTree(item) != null)
                    getTree(item).traverseInto(visitor);
            }
        }
        visitor.subtractNode();
    }

    public String toString() {
        ConvertToString<T> converter = new ConvertToString<T>();
        traverse(converter);
        return converter.toString();
    }

    public HashTree<T> get(Object key) {
        return getTree(key);
    }

    public HashTree<T> put(T key, HashTree<T> val) {
        set(key, val);
        return getTree(key);
    }

    public Set<Entry<T, HashTree<T>>> entrySet() {
        return data.entrySet();
    }

    public Set<T> keySet() {
        return data.keySet();
    }

    public Collection<HashTree<T>> values() {
        return data.values();
    }

    public void putAll(Map<? extends T, ? extends HashTree<T>> input) {
        data.putAll(input);
    }

    private class TreeSearcher<A> implements HashTreeTraverser<A> {
        Object target;
        HashTree<A> result;

        public TreeSearcher(Object t) {
            target = t;
        }

        public HashTree<A> getResult() {
            return result;
        }

        /* (non-Javadoc)
         * @see org.apache.jorphan.collections.HashTreeTraverser#addNode(java.lang.Object, org.apache.jorphan.collections.HashTree)
         */
        public void addNode(A node, HashTree<A> subTree) {
            result = subTree.getTree(target);
            if (result != null) {
                throw new RuntimeException("found"); //short circuit traversal when found
            }
        }

        /* (non-Javadoc)
         * @see org.apache.jorphan.collections.HashTreeTraverser#processPath()
         */
        public void processPath() {
            // TODO Auto-generated method stub

        }

        /* (non-Javadoc)
         * @see org.apache.jorphan.collections.HashTreeTraverser#subtractNode()
         */
        public void subtractNode() {
            // TODO Auto-generated method stub

        }
    }

    private class ConvertToString<A> implements HashTreeTraverser<A> {
        StringBuffer string = new StringBuffer(getClass().getName() + "{");
        StringBuffer spaces = new StringBuffer();
        int depth = 0;

        public void addNode(A key, HashTree<A> subTree) {
            depth++;
            string.append("\n" + getSpaces() + key + " {");
        }

        public void subtractNode() {
            string.append("\n" + getSpaces() + "}");
            depth--;
        }

        public void processPath() {
        }

        public String toString() {
            string.append("\n}");
            return string.toString();
        }

        private String getSpaces() {
            if (spaces.length() < depth * 2) {
                while (spaces.length() < depth * 2) {
                    spaces.append("  ");
                }
            } else if (spaces.length() > depth * 2) {
                spaces.setLength(depth * 2);
            }
            return spaces.toString();
        }
    }
}
