package eu.witherxse.dsa.list;

import eu.witherxse.dsa.queue.SimpleQueue;

import java.util.Objects;

/**
 * Simple doubly linked list implementation, may also be used as a FIFO queue.
 * @param <T>
 */
public class SimpleDoublyLinkedList<T> implements SimpleList<T>, SimpleQueue<T> {

    private Node<T> head;

    private Node<T> tail;

    private int length;

    public SimpleDoublyLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.setPrev(this.tail);
        newNode.setNext(null);
        if (Objects.isNull(head)) {
             this.head = newNode;
        }
        if (Objects.nonNull(this.tail)) {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        this.length++;
    }

    @Override
    public boolean remove(T element) {
        boolean result = false;
        Node<T> current = this.head;
        if (Objects.nonNull(current)) {
            while (Objects.nonNull(current) && !Objects.equals(current.getValue(), element)) {
                current = current.getNext();
            }
        }
        if (Objects.nonNull(current)) {
            result = true;
            removeNodeReferences(current);
        }
        return result;
    }

    @Override
    public boolean remove(int idx) {
        if (idx >= length) {
            throw new IndexOutOfBoundsException(idx);
        }
        boolean result = false;
        Node<T> current = findNodeAtIdx(idx);
        if (Objects.nonNull(current)) {
            result = true;
            removeNodeReferences(current);
            length--;
        }
        return result;
    }

    @Override
    public T get(int idx) {
        if (idx >= length) {
            throw new IndexOutOfBoundsException(idx);
        }
        Node<T> curNode = findNodeAtIdx(idx);
        return curNode.getValue();
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = this.head;
        boolean result = false;
        while (Objects.nonNull(current) && !result) {
            if (Objects.equals(current.getValue(), element)) {
                result = true;
            } else {
                current = current.getNext();
            }
        }
        return result;
    }

    @Override
    public void enqueue(T element) {
        add(element);
    }

    @Override
    public T dequeue() {
        T result = null;
        if (Objects.nonNull(this.head)) {
            result = this.head.getValue();
            remove(0);
        }
        return result;
    }

    @Override
    public T peek() {
        T result = null;
        if (!isEmpty() && Objects.nonNull(this.head)) {
            result = this.head.getValue();
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    private Node<T> findNodeAtIdx(int idx) {
        final int halfLength = length / 2;
        Node<T> current;
        if (idx > halfLength) {
            int startIdx = length - 1;
            current = this.tail;
            while (startIdx != idx) {
                current = current.getPrev();
                startIdx--;
            }
        } else {
            int startIdx = 0;
            current = this.head;
            while (startIdx != idx) {
                current = current.getNext();
                startIdx++;
            }
        }
        return current;
    }

    private void removeNodeReferences(Node<T> current) {
        Node<T> prev = current.getPrev();
        Node<T> next = current.getNext();
        if (Objects.nonNull(prev)) {
            prev.setNext(next);
        } else {
            this.head = next;
        }
        if (Objects.nonNull(next)) {
            next.setPrev(prev);
        } else {
            this.tail = prev;
        }
    }

    private static class Node <T> {
        private final T value;
        private Node<T> next;
        private Node<T> prev;

        Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public T getValue() {
            return value;
        }
    }
}
