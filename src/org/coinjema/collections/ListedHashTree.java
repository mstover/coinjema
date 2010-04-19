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
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * ListedHashTree is a different implementation of the {@link HashTree}
 * collection class. In the ListedHashTree, the order in which values are added
 * is preserved (not to be confused with {@link SortedHashTree}, which sorts
 * the order of the values using the compare() function).  Any listing of nodes
 * or iteration through the list of nodes of a ListedHashTree will be given in
 * the order in which the nodes were added to the tree.
 *
 * @see HashTree
 * @author  mstover1 at apache.org
 * @version $Revision: 1.2 $
 */
public class ListedHashTree<T> extends HashTree<T> implements Serializable, Cloneable
{
    private final static long serialVersionUID = 1;
    private List<T> order;

    public ListedHashTree()
    {
        data = new HashMap<T,HashTree<T>>();
        order = new LinkedList<T>();
    }

    public HashTree<T> clone()
    {
        ListedHashTree<T> newTree = new ListedHashTree<T>();
        cloneTree(newTree);
        return newTree;
    }

    public ListedHashTree(T key)
    {
        data = new HashMap<T,HashTree<T>>();
        order = new LinkedList<T>();
        data.put(key, new ListedHashTree<T>());
        order.add(key);
    }

    public ListedHashTree(Collection<? extends T> keys)
    {
        data = new HashMap<T,HashTree<T>>();
        order = new LinkedList<T>();
        for (T temp : keys)
        {
            data.put(temp, new ListedHashTree<T>());
            order.add(temp);
        }
    }

    public ListedHashTree(T[] keys)
    {
        data = new HashMap<T,HashTree<T>>();
        order = new LinkedList<T>();
        for (T x : keys)
        {
            data.put(x, new ListedHashTree<T>());
            order.add(x);
        }
    }

    public void set(T key, T value)
    {
        if (!data.containsKey(key))
        {
            order.add(key);
        }
        super.set(key, value);
    }

    public void set(T key, HashTree<T> t)
    {
        if (!data.containsKey(key))
        {
            order.add(key);
        }
        super.set(key, t);
    }

    public void set(T key, T[] values)
    {
        if (!data.containsKey(key))
        {
            order.add(key);
        }
        super.set(key, values);
    }

    public void set(T key, Collection<? extends T> values)
    {
        if (!data.containsKey(key))
        {
            order.add(key);
        }
        super.set(key, values);
    }

    public void replace(Object currentKey, T newKey)
    {
        HashTree<T> tree = getTree(currentKey);
        data.remove(currentKey);
        data.put(newKey, tree);
        order.set(order.indexOf(currentKey), newKey);
    }

    public HashTree<T> createNewTree()
    {
        return new ListedHashTree<T>();
    }

    public HashTree<T> createNewTree(T key)
    {
        return new ListedHashTree<T>(key);
    }

    public HashTree<T> createNewTree(Collection<? extends T> values)
    {
        return new ListedHashTree<T>(values);
    }

    public HashTree<T> add(T key)
    {
        if (!data.containsKey(key))
        {
            HashTree<T> newTree = createNewTree();
            data.put(key, newTree);
            order.add(key);
            return newTree;
        }
        else
        {
            return getTree(key);
        }
    }

    public Collection<T> list()
    {
        return order;
    }

    public HashTree<T> remove(Object key)
    {
        order.remove(key);
        return data.remove(key);
    }

    // Make sure the hashCode depends on the order as well
    public int hashCode()
    {
    	int hc = 17;
		hc = hc * 37 + (order == null ? 0 : order.hashCode());
		hc = hc * 37 + super.hashCode();
        return hc;
    }

    public boolean equals(Object o)
    {
		if (!(o instanceof ListedHashTree)) return false;
		ListedHashTree lht = (ListedHashTree) o;
    	return (super.equals(lht) && order.equals(lht.order));
    	
//        boolean flag = true;
//        if (o instanceof ListedHashTree)
//        {
//            ListedHashTree oo = (ListedHashTree) o;
//            Iterator it = order.iterator();
//            Iterator it2 = oo.order.iterator();
//            if (size() != oo.size())
//            {
//                flag = false;
//            }
//            while (it.hasNext() && it2.hasNext() && flag)
//            {
//                if (!it.next().equals(it2.next()))
//                {
//                    flag = false;
//                }
//            }
//            if (flag)
//            {
//                it = order.iterator();
//                while (it.hasNext() && flag)
//                {
//                    Object temp = it.next();
//                    flag = get(temp).equals(oo.get(temp));
//                }
//            }
//        }
//        else
//        {
//            flag = false;
//        }
//        return flag;
    }

    public int size()
    {
        return data.size();
    }

    void readObject(ObjectInputStream ois)
        throws ClassNotFoundException, IOException
    {
        ois.defaultReadObject();
    }

    void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.defaultWriteObject();
    }

    /* (non-Javadoc)
     * @see java.util.Map#clear()
     */
    public void clear() {
        super.clear();
        order.clear();
    }

	@Override
	public void set(HashTree<T> t) {
		if(t instanceof ListedHashTree)
		{
			order = ((ListedHashTree)t).order;
		}
		else
		{
			order.clear();
			order.addAll(t.data.keySet());
		}
		super.set(t);
	}
}
