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

/**
 * By implementing this interface, a class can easily traverse a HashTree
 * object, and be notified via callbacks of certain events.  There are three
 * such events:
 * <ol>
 *   <li>When a node is first encountered, the traverser's
 *       {@link #addNode(Object,HashTree)} method is called.  It is handed the
 *       object at that node, and the entire sub-tree of the node.</li>
 *   <li>When a leaf node is encountered, the traverser is notified that a full
 *       path has been finished via the {@link #processPath()} method.  It is
 *       the traversing class's responsibility to know the path that has just
 *       finished (this can be done by keeping a simple stack of all added
 *       nodes).</li>
 *   <li>When a node is retraced, the traverser's {@link #subtractNode()} is
 *       called.  Again, it is the traverser's responsibility to know which
 *       node has been retraced.</li>
 * </ol>
 * To summarize, as the traversal goes down a tree path, nodes are added.  When
 * the end of the path is reached, the {@link #processPath()} call is sent.  As
 * the traversal backs up, nodes are subtracted.
 * <p>
 * The traversal is a depth-first traversal.
 *  
 * @see HashTree
 * @see SearchByClass
 *
 * @author Michael Stover (mstover1 at apache.org)
 * @version $Revision: 1.1 $
 */
public interface HashTreeTraverser<T>
{
    /**
     * The tree traverses itself depth-first, calling addNode for each object
     * it encounters as it goes.  This is a callback method, and should not be
     * called except by a HashTree during traversal.
     * 
     * @param node    the node currently encountered
     * @param subTree the HashTree under the node encountered
     */
    public void addNode(T node, HashTree<T> subTree);

    /**
     * Indicates traversal has moved up a step, and the visitor should remove
     * the top node from its stack structure.  This is a callback method, and
     * should not be called except by a HashTree during traversal.
     */
    public void subtractNode();

    /**
     * Process path is called when a leaf is reached.  If a visitor wishes to
     * generate Lists of path elements to each leaf, it should keep a Stack
     * data structure of nodes passed to it with addNode, and removing top
     * items for every {@link #subtractNode()} call.  This is a callback
     * method, and should not be called except by a HashTree during traversal.
     */
    public void processPath();
}