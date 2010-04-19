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

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/**
 * SortedHashTree is a different implementation of the {@link HashTree}
 * collection class.  In the SortedHashTree, the ordering of values in the tree
 * is made explicit via the compare() function of objects added to the tree.
 * This works in exactly the same fashion as it does for a SortedSet.
 *
 * @see HashTree
 * @see HashTreeTraverser
 * 
 * @author    mstover1 at apache.org
 * @version   $Revision: 1.1 $
 */
public class SortedHashTree<T> extends HashTree<T> implements Serializable
{
    private static final long serialVersionUID = 1;
    //NOTUSED private static Logger log = LoggingManager.getLoggerForClass();
    protected Comparator<T> comparator;

    public SortedHashTree()
    {
        data = new TreeMap<T,HashTree<T>>();
    }
    
    public SortedHashTree(Comparator<T> comper)
    {
        comparator = comper;
        data = new TreeMap<T,HashTree<T>>(comparator);
    }

    public SortedHashTree(T key)
    {
        data = new TreeMap<T,HashTree<T>>();
        data.put(key, new SortedHashTree<T>());
    }
    
    public SortedHashTree(T key,Comparator<T> comper)
    {
        comparator = comper;
        data = new TreeMap<T,HashTree<T>>(comparator);
        data.put(key, new SortedHashTree<T>(comparator));
    }

    public SortedHashTree(Collection<? extends T> keys)
    {
        data = new TreeMap<T,HashTree<T>>();
        for (T it : keys)
        {
            data.put(it, new SortedHashTree<T>());
        }
    }
    
    public SortedHashTree(Collection<? extends T> keys,Comparator<T> comper)
    {
        comparator = comper;
        data = new TreeMap<T,HashTree<T>>(comparator);
        for (T it : keys)
        {
            data.put(it, new SortedHashTree<T>(comparator));
        }
    }

    public SortedHashTree(T[] keys)
    {
        data = new TreeMap<T,HashTree<T>>();
        for (int x = 0; x < keys.length; x++)
        {
            data.put(keys[x], new SortedHashTree<T>());
        }
    }
    
    public SortedHashTree(T[] keys,Comparator<T> comper)
    {
        comparator = comper;
        data = new TreeMap<T,HashTree<T>>(comparator);
        for (int x = 0; x < keys.length; x++)
        {
            data.put(keys[x], new SortedHashTree<T>(comparator));
        }
    }

    protected HashTree<T> createNewTree()
    {
        if(comparator == null)
        {
            return new SortedHashTree<T>();
        }
        else
        {
            return new SortedHashTree<T>(comparator);
        }
    }

    protected HashTree<T> createNewTree(T key)
    {
        if(comparator == null)
        {
            return new SortedHashTree<T>(key);
        }
        else
        {
            return new SortedHashTree<T>(key,comparator);
        }
    }

    protected HashTree<T> createNewTree(Collection<? extends T> values)
    {
        if(comparator == null)
        {
            return new SortedHashTree<T>(values);
        }
        else
        {
            return new SortedHashTree<T>(values,comparator);
        }
    }

    public HashTree<T> clone()
    {
        HashTree<T> newTree = null;
        if(comparator == null)
        {
            newTree = new SortedHashTree<T>();
        }
        else
        {
            newTree = new SortedHashTree<T>(comparator);
        }
        newTree.data = (Map<T,HashTree<T>>) ((TreeMap)data).clone();
        return newTree;
    }
    /**
     * @param comparator The comparator to set.
     */
    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }
}
