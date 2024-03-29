/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.dag;

import edu.neu.coe.info6205.bqs.BQSException;
import edu.neu.coe.info6205.bqs.Stack;
import edu.neu.coe.info6205.bqs.Stack_LinkedList;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

import static org.junit.Assert.*;

public class DAGTest {

    /**
     * Test method for DAG()
     */
    @Test
    public void testDAG() {
        DAG_Impl<Integer> target = new DAG_Impl<>();
        assertNotNull(target);
        assertEquals(0, target.E());
        assertEquals(0, target.V());
        assertFalse(target.edges().iterator().hasNext());
        assertFalse(target.vertices().iterator().hasNext());
    }

    /**
     * Test method for addEdge
     */
    @Test
    public void testAddEdge() {
        DAG_Impl<Integer> target = new DAG_Impl<>();
        Edge<Integer> edge = new Edge<>(1, 2);
        target.addEdge(edge);
        assertEquals(1, target.E());
        assertEquals(2, target.V());
        assertTrue(target.edges().iterator().hasNext());
        assertTrue(target.vertices().iterator().hasNext());
        assertEquals(edge, target.edges().iterator().next());
        assertEquals(new Integer(1), target.vertices().iterator().next());
    }

    /**
     * Test method for DAG
     */
    @Test
    public void testDag2() {
        DAG_Impl<Integer> target = setupStandardDAG();
        assertEquals(11, target.E());
        assertEquals(7, target.V());
        assertEquals(Integer.valueOf(0), target.edges().iterator().next().getFrom());
        assertEquals(Integer.valueOf(0), target.vertices().iterator().next());
        assertEquals(Integer.valueOf(1), target.adjacent(0).iterator().next().getTo());
        assertFalse(target.adjacent(2).iterator().hasNext());
        assertEquals(Integer.valueOf(4), target.adjacent(1).iterator().next().getTo());
    }

    /**
     * Test method for reverse
     */
    @Test
    public void testReverse() {
        DAG<Integer> target = setupStandardDAG();
        DAG_Impl<Integer> integerDAG = (DAG_Impl<Integer>) target.reverse();
        assertEquals(11, integerDAG.E());
        assertEquals(7, integerDAG.V());
        assertEquals(Integer.valueOf(0), integerDAG.edges().iterator().next().getFrom());
        assertEquals(Integer.valueOf(0), integerDAG.vertices().iterator().next());
        assertEquals(Integer.valueOf(6), integerDAG.adjacent(0).iterator().next().getTo());
        assertFalse(integerDAG.adjacent(3).iterator().hasNext());
        assertEquals(Integer.valueOf(0), integerDAG.adjacent(1).iterator().next().getTo());
    }

    /**
     * Test method for DFS
     */
    @Test
    public void testDFS() {
        Queue<Integer> preOrder = new LinkedList<>();
        Queue<Integer> postOrder = new LinkedList<>();
        Stack<Integer> reversePostOrder = new Stack_LinkedList<>();
        DAG_Impl<Integer> target = setupStandardDAG();
        Function<Integer, Void> pre = (v) -> {
            preOrder.add(v);
            return null;
        };
        Function<Integer, Void> post = (v) -> {
            postOrder.add(v);
            reversePostOrder.push(v);
            return null;
        };

        target.dfs(0, pre, post);
        assertEquals(Integer.valueOf(0), ((LinkedList<Integer>) preOrder).getFirst());
        assertEquals(Integer.valueOf(5), ((LinkedList<Integer>) preOrder).getLast());
        assertEquals(Integer.valueOf(4), ((LinkedList<Integer>) postOrder).getFirst());
        assertEquals(Integer.valueOf(0), ((LinkedList<Integer>) postOrder).getLast());
        try {
            assertEquals(Integer.valueOf(0), (reversePostOrder).pop());
            assertEquals(Integer.valueOf(5), (reversePostOrder).pop());
            assertEquals(Integer.valueOf(2), (reversePostOrder).pop());
            assertEquals(Integer.valueOf(1), (reversePostOrder).pop());
            assertEquals(Integer.valueOf(4), (reversePostOrder).pop());
        } catch (BQSException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test method for sorted
     */
    @Test
    public void testSorted() {
        DAG_Impl<Integer> target = setupStandardDAG();
        Iterable<Integer> sorted = target.sorted();
        Iterator<Integer> iterator = sorted.iterator();
        assertEquals(Integer.valueOf(3), iterator.next());
        assertEquals(Integer.valueOf(6), iterator.next());
        assertEquals(Integer.valueOf(0), iterator.next());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(4), iterator.next());
        assertFalse(iterator.hasNext());
    }

    private DAG_Impl<Integer> setupStandardDAG() {
        DAG_Impl<Integer> target = new DAG_Impl<>();
        target.addEdge(0, 1);
        target.addEdge(0, 2);
        target.addEdge(0, 5);
        target.addEdge(1, 4);
        target.addEdge(3, 2);
        target.addEdge(3, 4);
        target.addEdge(3, 5);
        target.addEdge(3, 6);
        target.addEdge(5, 2);
        target.addEdge(6, 0);
        target.addEdge(6, 4);
        return target;
    }

}
