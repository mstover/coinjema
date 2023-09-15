/*
 * Created on Jan 9, 2004
 *
 * This file is from the Coinjema project on sourceforge.net (http://coinjema.sourceforge.net)
 * This file is Public Domain software.
 */
package org.coinjema.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * @author Michael Stover
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class TreeSorter<T> implements HashTreeTraverser<T> {
	
	T key;
	Comparator<T> comper;
	
	
	public TreeSorter(T key,Comparator<T> comper){
		this.key = key;
		this.comper = comper;
	}
   
   public TreeSorter(Comparator<T> comper)
   {
      this.comper = comper;
   }
   
   public TreeSorter()
   {      
   }
   
   public TreeSorter(T key)
   {
      this.key = key;
   }

	/* (non-Javadoc)
	 * @see org.apache.jorphan.collections.HashTreeTraverser#addNode(java.lang.Object, org.apache.jorphan.collections.HashTree)
	 */
	public void addNode(T arg0, HashTree<T> arg1) {
		if(key == null || arg0.equals(key))
		{
			Collection coll = arg1.list();
			if(coll instanceof List)
			{
            if(comper != null)
			   {
               Collections.sort((List)coll,comper);
            }
            else
            {
               Collections.sort((List)coll);
            }
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.jorphan.collections.HashTreeTraverser#subtractNode()
	 */
	public void subtractNode() {

	}

	/* (non-Javadoc)
	 * @see org.apache.jorphan.collections.HashTreeTraverser#processPath()
	 */
	public void processPath() {

	}

}
