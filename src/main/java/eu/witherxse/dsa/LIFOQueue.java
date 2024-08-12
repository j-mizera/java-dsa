package eu.witherxse.dsa;

import java.util.Objects;
import java.util.Optional;

public class LIFOQueue<T> implements SimpleQueue<T> {

    private Node<T> head;
    private int length;

    public LIFOQueue() {
        this.length = 0;
        this.head = null;
    }

    @Override
    public void enqueue(T element) {
        length++;
        Node<T> created = new Node<>(element);
        created.setPrev(this.head);
        this.head = created;
    }

    @Override
    public T dequeue() {
        T result = null;
        if (Objects.nonNull(this.head)) {
            result = this.head.getValue();
            this.head = this.head.getPrev();
            length--;
        }
        return result;
    }

    @Override
    public T peek() {
        T result = null;
        if (Objects.nonNull(this.head)) {
            result = this.head.getValue();
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> prev;

        private Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}
