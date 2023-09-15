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
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @author Michael Stover (mstover1 at apache.org)
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ConfigurationTree implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;


    ListedHashTree<String> propTree;

    public ConfigurationTree() {
        propTree = new ListedHashTree<String>();
    }
    
    public ConfigurationTree(Reader r) throws IOException
    {
        this();
        ConfigurationTreeParser.fromXML(r,this);
    }

    public ConfigurationTree(String value) {
        propTree = new ListedHashTree<String>();
        setValue(value);
    }

    public ConfigurationTree(ListedHashTree<String> data) {
        propTree = data;
    }

    public ConfigurationTree(ListedHashTree<String> data, String value) {
        propTree = data;
        setValue(value);
    }

    /**
     * @param keys
     */
    public void add(Collection<String> keys) {
        propTree.add(keys);
    }

    /**
     * @param treePath
     * @param values
     */
    public void add(Collection<String> treePath, Collection<String> values) {
        propTree.add(treePath, values);
    }

    /**
     * @param treePath
     * @param value
     * @return
     */
    public ConfigurationTree add(Collection<String> treePath, String value) {
        return makeSubtree(propTree.add(treePath,
                value));
    }

    /**
     * @param treePath
     * @param values
     */
    public void add(Collection<String> treePath, String[] values) {
        propTree.add(treePath, values);
    }

    /**
     * @param newTree
     */
    public void add(ConfigurationTree newTree) {
        propTree.add(newTree.propTree);
    }

    /**
     * @param key
     * @return
     */
    public ConfigurationTree add(String key) {
        String[] keys = getPath(key);
        HashTree<String> tree = propTree;
        for (int i = 0; i < keys.length; i++) {
            tree = tree.add(keys[i]);
        }
        return makeSubtree(tree);
    }
    
    public ConfigurationTree addRaw(String key,String value)
    {
        return makeSubtree(propTree.add(key,value));
    }
    
    public ConfigurationTree addRaw(String key)
    {
        return makeSubtree(propTree.add(key));
    }

    /**
     * @param key
     * @param values
     */
    public void add(String key, Collection<String> values) {
        propTree.add(getPath(key), values);
    }

    /**
     * @param key
     * @param subTree
     */
    public void add(String key, ConfigurationTree subTree) {
        propTree.add(getPath(key),subTree.propTree);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public ConfigurationTree add(String key, String value) {
        return makeSubtree(propTree.add(getPath(key), value));
    }
    
    public Properties getAsProperties(String key)
    {
        return getAsProperties(getTree(key));
    }
    
    public Properties getAsProperties()
    {
        return getAsProperties(this);
    }
    
    protected Properties getAsProperties(ConfigurationTree tree)
    {
       Properties props = new Properties();
       if(tree == null) return props;
       String[] propNames = tree.getPropertyNames();
       if(propNames == null) return props;
       for(int i = 0;i < propNames.length;i++)
       {
           if(tree.getProperty(propNames[i]) != null)
               props.setProperty(propNames[i],tree.getProperty(propNames[i]));
       }
       return props;
    }

    /**
     * @param key
     * @param values
     */
    public void add(String key, String[] values) {
        propTree.add(getPath(key), values);
    }

    /**
     * @param keys
     */
    public void add(String[] keys) {
        propTree.add(keys);
    }

    /**
     * @param treePath
     * @param values
     */
    public void add(String[] treePath, Collection<String> values) {
        propTree.add(treePath, values);
    }

    /**
     * @param treePath
     * @param value
     * @return
     */
    public ConfigurationTree add(String[] treePath, String value) {
        return makeSubtree(propTree.add(treePath,value));
    }

    /**
     * @param treePath
     * @param values
     */
    public void add(String[] treePath, String[] values) {
        propTree.add(treePath, values);
    }
    
    public void add(Properties props)
    {
        Iterator iter = props.keySet().iterator();
        while(iter.hasNext())
        {
            String key = (String)iter.next();
            add(key,props.getProperty(key));
        }
    }

    /**
     * @param treePath
     * @return
     */
    protected ConfigurationTree addTreePath(Collection<String> treePath) {
        return makeSubtree(propTree.addTreePath(treePath));
    }

    /**
     * 
     */
    public void clear() {
        propTree.clear();
    }

    /**
     * @param o
     * @return
     */
    public boolean containsKey(String o) {
        return propTree.getTree(getPath(o)) != null;
    }

    /**
     * @param value
     * @return
     */
    public boolean containsValue(String value) {
        return propTree.getTree(getPath(value)) != null;
    }

    protected String[] getPath(String key) {
        if (key != null) {
            String[] keys = key.split("/");
            return keys;
        }
        return new String[0];
    }
    
    public String getProperty(String key,String def)
    {
        return getProperty(getPath(key),def);
    }

    /**
     * @param key
     * @return
     */
    public String getProperty(String key) {
        return getProperty(getPath(key),null);
    }
    
    public String getProperty(String[] keys,String def)
    {
        String actual = propTree.getObject(keys);
        if(actual == null) actual = def;
        return actual;
    }
    
    public String getProperty(String[] keys)
    {
        return getProperty(keys,null);
    }

    /**
     * @return
     */
    public String[] getPropertyNames() {
        return convertArray(propTree.list());
    }

    /**
     * @param vals
     * @return
     */
    private String[] convertArray(Collection<String> vals) {
        if(vals == null) return new String[0];
        int s = vals.size();
        int count = 0;
        if(vals.contains(ConfigurationTreeParser.VALUE)) s--;
        String[] temp = new String[s];
        for(String item : vals)
        {
            if(!ConfigurationTreeParser.VALUE.equals(item)) 
                temp[count++] = item;
        }
        return temp;
    }

    /**
     * @param treePath
     * @return
     */
    public String[] getPropertyNames(Collection<String> treePath) {
        return convertArray(propTree.list(treePath));
    }

    /**
     * @param key
     * @return
     */
    public String[] getPropertyNames(String key) {
        return convertArray(propTree.list(getPath(key)));
    }

    /**
     * @param treePath
     * @return
     */
    public String[] getPropertyNames(String[] treePath) {
        return convertArray(propTree.list(treePath));
    }

    /**
     * @param treePath
     * @return
     */
    public ConfigurationTree getTree(Collection<String> treePath) {
        return makeSubtree(propTree.getTree(treePath));
    }

    /**
     * @param key
     * @return
     */
    public ConfigurationTree getTree(String key) {
        return makeSubtree(propTree.getTree(getPath(key)));
    }

    /**
     * @param treePath
     * @return
     */
    public ConfigurationTree getTree(String[] treePath) {
        return makeSubtree(propTree.getTree(treePath));
    }

    /**
     * @param subTree
     * @return
     */
    private ConfigurationTree makeSubtree(HashTree<String> subTree) {
        if(subTree != null)
            return new ConfigurationTree((ListedHashTree<String>)subTree);
        else
            return null;
    }

    /**
     * @param treePath
     * @return
     */
    protected ConfigurationTree getTreePath(Collection<String> treePath) {
        return makeSubtree(propTree.getTree(treePath));
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return propTree.isEmpty();
    }

    /**
     * @return
     */
    public Collection<String> listPropertyNames() {
        return purgeValue(propTree.list());
    }
    
    protected Collection<String> purgeValue(Collection<String> l)
    {
        List<String> nl = new LinkedList<String>(l);
        nl.remove(ConfigurationTreeParser.VALUE);
        return nl;
    }

    /**
     * @param treePath
     * @return
     */
    public Collection<String> listPropertyNames(Collection<String> treePath) {
        return purgeValue(propTree.list(treePath));
    }

    /**
     * @param key
     * @return
     */
    public Collection<String> listPropertyNames(String key) {
        return purgeValue(propTree.list(getPath(key)));
    }

    /**
     * @param treePath
     * @return
     */
    public Collection<String> listPropertyNames(String[] treePath) {
        return purgeValue(propTree.list(treePath));
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public String put(String key, String value) {
        propTree.add(getPath(key), value);
        return value;
    }

    /**
     * @param key
     * @return
     */
    public String remove(String key) {
        String[] keys = key.split("/");
        String prop = null;
        HashTree<String> tree = propTree;
        for (int i = 0; i < keys.length && tree != null; i++) {
            if ((i + 1) == keys.length) {
                tree = tree.remove(keys[i]);
                if (tree.list() != null && tree.list().size() == 1) {
                    prop = tree.list().iterator().next();
                }
            } else {
                tree = tree.getTree(keys[i]);
            }
        }
        return prop;
    }

    /**
     * @param currentKey
     * @param newKey
     */
    public void replace(String currentKey, String newKey) {
        String[] currentKeys = getPath(currentKey);
        String[] newKeys = getPath(newKey);
        HashTree<String> tree = propTree;
        if (currentKeys.length == newKeys.length) {
            for (int i = 0; i < currentKeys.length; i++) {
                tree.replaceKey(currentKeys[i], newKeys[i]);
                tree = tree.getTree(newKeys[i]);
            }
        }
    }

    /**
     * @param key
     * @return
     */
    public ConfigurationTree search(String key) {
        return makeSubtree(propTree.search(key));
    }

    /**
     * @param values
     */
    public void setProperty(Collection<String> values) {
        propTree.set(values);
    }

    /**
     * @param treePath
     * @param values
     */
    public void setProperty(Collection<String> treePath, Collection<String> values) {
        propTree.set(treePath, values);
    }

    /**
     * @param treePath
     * @param values
     */
    public void setProperty(Collection<String> treePath, String[] values) {
        propTree.set(treePath, values);
    }

    /**
     * @param key
     * @param values
     */
    public void setProperty(String key, Collection<String> values) {
        propTree.set(getPath(key), values);
    }

    /**
     * @param key
     * @param t
     */
    public void setProperty(String key, ConfigurationTree t) {
        String[] keys = getPath(key);
        HashTree<String> tree = propTree.getTree(keys);
        if (tree != null) {
            tree.clear();
            tree.add(t.propTree);
        } else {
            propTree.add(keys);
            propTree.getTree(keys).add(t.propTree);
        }
    }

    /**
     * @param key
     * @param value
     */
    public void setProperty(String key, String value) {
        HashTree<String> tree = propTree.getTree(getPath(key));
        if (tree != null) {
            tree.clear();
            tree.add(value);
        } else {
            propTree.add(getPath(key), value);
        }
    }

    /**
     * @param key
     * @param values
     */
    public void setProperty(String key, String[] values) {
        propTree.set(getPath(key), values);
    }

    /**
     * @param treePath
     * @param values
     */
    public void setProperty(String[] treePath, Collection<String> values) {
        propTree.set(treePath, values);
    }

    /**
     * @param treePath
     * @param values
     */
    public void setProperty(String[] treePath, String[] values) {
        propTree.set(treePath, values);
    }

    /**
     * @return
     */
    public int size() {
        return propTree.size();
    }

    /**
     * @param visitor
     */
    public void traverse(HashTreeTraverser<String> visitor) {
        propTree.traverse(visitor);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    protected Object clone() throws CloneNotSupportedException {
        ConfigurationTree config = new ConfigurationTree();
        config.propTree = (ListedHashTree<String>)propTree.clone();
        return config;
    }

    protected void getSpaces(int level, Writer buf) throws IOException {
        for (int i = 0; i < level; i++)
            buf.write("    ");
    }

    public String toString() {
        StringWriter buf = new StringWriter();
        try {
            ConfigurationTreeParser.toXML(buf,this);
        } catch (IOException e) {
            // this can't happen
        }
        return buf.toString();
    }

    protected boolean isLeaf(String key) {
        ConfigurationTree tree = getTree(key);
        String[] vals = tree.getPropertyNames();
        if (vals == null
                || vals.length == 0
                || (vals.length == 1 && (tree.listPropertyNames(vals[0]) == null || tree
                        .listPropertyNames(vals[0]).size() == 0))) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return getProperty(ConfigurationTreeParser.VALUE);
    }
    
    /**
     * Get the value or return the given default value if null
     * @param def
     * @return
     */
    public String getValueOr(String def)
    {
        String v = getValue();
        if(v == null)
        {
            return def;
        }
        return v;
    }
    
    public String getValue(String name)
    {
        ConfigurationTree tree = getTree(getPath(name));
        if(tree != null)
        {
            return tree.getValue();
        }
        return null;
    }
    
    public String getValue(String key,String def)
    {
        String v = getValue(key);
        if(v == null)
        {
            return def;
        }
        return v;
    }

    /**
     * @param value
     *            The value to set.
     */
    public void setValue(String value) {
        setProperty(ConfigurationTreeParser.VALUE, value);
    }
    
    public void setValue(String name,String value)
    {
        ConfigurationTree tree = getTree(getPath(name));
        if(tree != null)
        {
            tree.setValue(value);
        }
        else
        {
            add(name).setValue(value);
        }
        
    }
}
