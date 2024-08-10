package eu.witherxse.dsa;

/**
 * Simple list interface.
 */
public interface SimpleList<T> {

    /**
     * Adds element to the end of the list.
     * @param element
     */
    void add(T element);

    /**
     * Removes first element from the list.
     * @param element
     */
    boolean remove(T element);

    /**
     * Removes element at index.
     * @param idx
     */
    boolean remove(int idx);

    /**
     * Returns element at index.
     * @param idx
     * @return element
     */
    T get(int idx);

    /**
     * Returns true if list contains element.
     * @param element
     * @return
     */
    boolean contains(T element);

    /**
     * Returns true if list is empty.
     * @return
     */
    boolean isEmpty();
}
