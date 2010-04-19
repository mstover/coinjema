/**
 * 
 */
package org.coinjema.collections;

import junit.framework.TestCase;

public class TestSearchByClass extends TestCase
{
    public TestSearchByClass(String name)
    {
        super(name);
    }
    public void testSearch() throws Exception
    {
        ListedHashTree tree = new ListedHashTree();
        SearchByClass searcher = new SearchByClass(Integer.class);
        String one = "one";
        String two = "two";
        Integer o = new Integer(1);
        tree.add(one, o);
        tree.getTree(one).add(o, two);
        tree.traverse(searcher);
        assertEquals(1, searcher.getSearchResults().size());
    }
}