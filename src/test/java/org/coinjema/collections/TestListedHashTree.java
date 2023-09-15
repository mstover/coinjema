/**
 *
 */
package org.coinjema.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestListedHashTree {

    @Test
    public void testAddObjectAndTree() throws Exception {
        ListedHashTree<String> tree = new ListedHashTree<String>("key");
        ListedHashTree<String> newTree = new ListedHashTree<String>("value");
        tree.add("key", newTree);
        assertEquals(tree.list().size(), 1);
        assertEquals("key", tree.getObject());
        assertEquals(1, tree.getTree("key").list().size());
        assertEquals(0, tree.getTree("key").getTree("value").size());
        assertEquals(tree.getTree("key").getObject(), "value");
        assertNotNull(tree.getTree("key").getTree("value"));
    }

    @Test
    public void testEqualsAndHashCode() throws Exception {
        ListedHashTree<String> tree1 = new ListedHashTree<String>("abcd");
        ListedHashTree<String> tree2 = new ListedHashTree<String>("abcd");
        ListedHashTree<String> tree3 = new ListedHashTree<String>("abcde");
        ListedHashTree<String> tree4 = new ListedHashTree<String>("abcde");

        assertTrue(tree1.equals(tree1));
        assertTrue(tree1.equals(tree2));
        assertTrue(tree2.equals(tree1));
        assertTrue(tree2.equals(tree2));
        assertTrue(tree1.hashCode() == tree2.hashCode());

        assertTrue(tree3.equals(tree3));
        assertTrue(tree3.equals(tree4));
        assertTrue(tree4.equals(tree3));
        assertTrue(tree4.equals(tree4));
        assertTrue(tree3.hashCode() == tree4.hashCode());

        assertNotSame(tree1, tree2);
        assertNotSame(tree1, tree3);
        assertFalse(tree1.equals(tree3));
        assertFalse(tree3.equals(tree1));
        assertFalse(tree1.equals(tree4));
        assertFalse(tree4.equals(tree1));

        assertFalse(tree2.equals(tree3));
        assertFalse(tree3.equals(tree2));
        assertFalse(tree2.equals(tree4));
        assertFalse(tree4.equals(tree2));

        tree1.add("abcd", tree3);
        assertFalse(tree1.equals(tree2));
        assertFalse(tree2.equals(tree1));

        tree2.add("abcd", tree4);
        assertTrue(tree1.equals(tree2));
        assertTrue(tree2.equals(tree1));
        assertTrue(tree1.hashCode() == tree2.hashCode());

        tree1.add("a1");
        tree1.add("a2");
        //tree1.add("a3");
        tree2.add("a2");
        tree2.add("a1");

        assertFalse(tree1.equals(tree2));
        assertFalse(tree2.equals(tree1));
        if (tree1.hashCode() == tree2.hashCode()) {
            //This is not a requirement
            System.out.println("WARN: unequal ListedHashTrees should not have equal hashcodes");

        }

        tree4.add("abcdef");
        assertFalse(tree3.equals(tree4));
        assertFalse(tree4.equals(tree3));
    }
}