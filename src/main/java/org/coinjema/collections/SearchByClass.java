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

import java.util.*;

/**
 * Useful for finding all nodes in the tree that represent objects of a
 * particular type.  For instance, if your tree contains all strings, and a few
 * StringBuffer objects, you can use the SearchByClass traverser to find all
 * the StringBuffer objects in your tree.  
 * <p>
 * Usage is simple.  Given a {@link HashTree} object "tree", and a
 * SearchByClass object:
 * <pre>
 *  HashTree tree = new HashTree();
 *  // ... tree gets filled with objects
 *  SearchByClass searcher = new SearchByClass(StringBuffer.class);
 *  tree.traverse(searcher);
 *  Iterator iter = searcher.getSearchResults().iterator();
 *  while(iter.hasNext())
 *  {
 *      StringBuffer foundNode = (StringBuffer)iter.next();
 *      HashTree subTreeOfFoundNode = searcher.getSubTree(foundNode);
 *      //  .... do something with node and subTree...
 *  }
 * </pre>
 * 
 * @see HashTree
 * @see HashTreeTraverser
 *
 * @author Michael Stover (mstover1 at apache.org)
 * @version $Revision: 1.2 $
 */
public class SearchByClass<T> implements HashTreeTraverser<T>
{
    List<T> objectsOfClass = new LinkedList<T>();
    Map<T,HashTree<T>> subTrees = new HashMap<T,HashTree<T>>();
    Class<T> searchClass = null;

    /**
     * Creates an instance of SearchByClass, and sets the Class to be searched
     * for.
     * 
     * @param searchClass
     */
    public SearchByClass(Class<T> searchClass)
    {
        this.searchClass = searchClass;
    }
    
    /**
     * After traversing the HashTree, call this method to get a collection of
     * the nodes that were found.
     * 
     * @return Collection  All found nodes of the requested type
     */
    public Collection<T> getSearchResults()
    {
        return objectsOfClass;
    }
    
    /**
     * Given a specific found node, this method will return the sub tree of
     * that node.
     * 
     * @param root the node for which the sub tree is requested
     * @return HashTree
     */
    public HashTree<T> getSubTree(T root)
    {
        return subTrees.get(root);
    }
    
    public void addNode(T node, HashTree<T> subTree)
    {
        if (searchClass.isAssignableFrom(node.getClass()))
        {
            objectsOfClass.add(node);
            ListedHashTree<T> tree = new ListedHashTree<T>(node);
            tree.set(node, subTree);
            subTrees.put(node, tree);
        }
    }
    
    public void subtractNode()
    {
    }

    public void processPath()
    {
    }
}