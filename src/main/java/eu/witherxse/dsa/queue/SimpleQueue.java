package eu.witherxse.dsa.queue;

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
    T dequeue();

    /**
     * Returns element from the front of the queue without removing it.
     * @return
     */
    T peek();

    /**
     * Returns true if queue is empty.
     * @return
     */
    boolean isEmpty();
}
