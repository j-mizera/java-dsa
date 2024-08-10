package eu.witherxse.dsa;

import java.util.Optional;

/**
 * Queue interface with simple linked queue implementation.
 */
public interface SimpleQueue<T> {

    /**
     * Adds element to the end of the queue.
     * @param element
     */
    void enqueue(T element);

    /**
     * Removes and returns element from the front of the queue.
     * @return
     */
    Optional<T> dequeue();

    /**
     * Returns element from the front of the queue without removing it.
     * @return
     */
    Optional<T> peek();

    /**
     * Returns true if queue is empty.
     * @return
     */
    boolean isEmpty();
}
