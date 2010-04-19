/**
 * 
 */
package org.coinjema.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import junit.framework.TestCase;

public class TestHashTree extends TestCase
{
    public TestHashTree(String name)
    {
        super(name);
    }

    public void testAdd1() throws Exception
    {
        Collection<String> treePath =
            Arrays.asList(new String[] { "1", "2", "3", "4" });
        HashTree<String> tree = new HashTree<String>();
        tree.add(treePath, "value");
        assertEquals(1, tree.list(treePath).size());
        assertEquals("value", tree.getObject(treePath));
    }
    
	public void testEqualsAndHashCode() throws Exception
	{
		HashTree<String> tree1 = new HashTree<String>("abcd");
		HashTree<String> tree2 = new HashTree<String>("abcd");
		HashTree<String> tree3 = new HashTree<String>("abcde");
		HashTree<String> tree4 = new HashTree<String>("abcde");
		
		assertTrue(tree1.equals(tree1));
		assertTrue(tree1.equals(tree2));
		assertTrue(tree2.equals(tree1));
		assertTrue(tree2.equals(tree2));
		assertTrue(tree1.hashCode()==tree2.hashCode());

		assertTrue(tree3.equals(tree3));
		assertTrue(tree3.equals(tree4));
		assertTrue(tree4.equals(tree3));
		assertTrue(tree4.equals(tree4));
		assertTrue(tree3.hashCode()==tree4.hashCode());

		assertNotSame(tree1,tree2);
		assertNotSame(tree1,tree3);
		assertNotSame(tree1,tree4);
		assertNotSame(tree2,tree3);
		assertNotSame(tree2,tree4);
		
		assertFalse(tree1.equals(tree3));
		assertFalse(tree1.equals(tree4));
		assertFalse(tree2.equals(tree3));
		assertFalse(tree2.equals(tree4));
		
		assertNotNull(tree1);
		assertNotNull(tree2);

		tree1.add("abcd",tree3);
		assertFalse(tree1.equals(tree2));
		assertFalse(tree2.equals(tree1));// Check reflexive
		if (tree1.hashCode()==tree2.hashCode())
		{
			// This is not a requirement
			System.out.println("WARN: unequal HashTrees should not have equal hashCodes");
		}
		tree2.add("abcd",tree4);
		assertTrue(tree1.equals(tree2));
		assertTrue(tree2.equals(tree1));
		assertTrue(tree1.hashCode()==tree2.hashCode());
    }
    
    public void testGenericAdd() throws Exception
    {
        Collection<String> values = new LinkedList<String>();
        values.add("a");
        values.add("b");
        values.add("c");
        HashTree<Object> tree = new HashTree<Object>();
        tree.add(values);
        assertEquals(3,tree.list().size());
        assertTrue(tree.list().contains("b"));
    }
}