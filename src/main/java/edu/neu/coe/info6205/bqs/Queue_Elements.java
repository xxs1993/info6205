/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.bqs;

public class Queue_Elements<Item> implements Queue<Item> {

    /**
     * Construct a new (empty) queue.
     */
    public Queue_Elements() {
        oldest = null;
        newest = null;
    }

    /**
     * Enqueue the given item into the linked list referenced by oldest
     *
     * @param item the item to add
     */
    public void enqueue( Item item) {
        // TODO
    }


    /**
     * Dequeue an element from the oldest list and return the item.
     *
     * @return the value of the oldest element.
     */
    public Item dequeue() {
        if (isEmpty()) return null;
        else {
            // TODO
            return null;
        }
    }

    public boolean isEmpty() {
        return oldest == null;
    }

    // This Element essentially begins a LinkedList of Elements which correspond
    // to the elements that can be taken from the queue (head points to the oldest element).
    // However, it is built in manner that requires a pointer to the newest element.
    private Element<Item> oldest;

    // This element always points to the newest (tail-most) element in the LinkedList referenced by oldest.
    private Element<Item> newest;
}
