/**
 *
 */
package org.coinjema.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSearchByClass {
    @Test
    public void testSearch() throws Exception {
        ListedHashTree tree = new ListedHashTree();
        SearchByClass searcher = new SearchByClass(Integer.class);
        String one = "one";
        String two = "two";
        Integer o = Integer.valueOf(1);
        tree.add(one, o);
        tree.getTree(one).add(o, two);
        tree.traverse(searcher);
        assertEquals(1, searcher.getSearchResults().size());
    }
}