package eu.witherxse.dsa.map;

import java.util.Objects;

/**
 * LRU map implementation. Allows to construct simple caching mechanism with fixed capacity.
 *
 * @param <K>
 * @param <V>
 */
public class LRUMap<K, V> implements SimpleMap<K, V> {

    private final int maxCapacity;
    private int length;
    private Node<V> head;
    private Node<V> tail;
    private SimpleMap<K, Node<V>> lookup;
    private SimpleMap<Node<V>, K> reverseLookup;

    public LRUMap(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.length = 0;
        this.head = null;
        this.tail = null;
        this.lookup = new SimpleHashMap<>();
        this.reverseLookup = new SimpleHashMap<>();
    }

    @Override
    public void put(K key, V value) {
        Node<V> node = lookup.get(key);
        if (Objects.nonNull(node)) {
            this.detatchNode(node);
            this.prependNode(node);
        } else {
            this.length++;
            node = new Node<>(value);
            this.prependNode(node);
            this.shrinkCache();
            this.lookup.put(key, node);
            this.reverseLookup.put(node, key);
        }
    }

    @Override
    public V get(K key) {
        Node<V> node = lookup.get(key);
        V value = null;
        if (Objects.nonNull(node)) {
            value = node.getValue();
            this.detatchNode(node);
            this.prependNode(node);
        }
        return value;
    }

    @Override
    public void remove(K key) {
        Node<V> node = lookup.get(key);
        if (Objects.nonNull(node)) {
            this.detatchNode(node);
            this.lookup.remove(key);
        }
    }

    @Override
    public boolean contains(K key) {
        return this.lookup.contains(key);
    }

    private void detatchNode(Node<V> node) {
        if (Objects.nonNull(node.getPrev())) {
            node.getPrev().setNext(node.getNext());
        }
        if (Objects.nonNull(node.getNext())) {
            node.getNext().setPrev(node.getPrev());
        }

        if (Objects.equals(this.head, node)) {
            this.head = node.getNext();
        }
        if (Objects.equals(this.tail, node)) {
            this.tail = node.getPrev();
        }
        node.setNext(null);
        node.setPrev(null);
    }

    private void prependNode(Node<V> node) {
        if (Objects.isNull(this.head)) {
            this.head = this.tail = node;
        } else {
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;
        }
    }

    private void shrinkCache() {
        while (this.length > this.maxCapacity) {
            Node<V> tail = this.tail;
            this.detatchNode(this.tail);
            K key = this.reverseLookup.get(tail);
            this.lookup.remove(key);
            this.reverseLookup.remove(tail);
            this.length--;
        }
    }

    private static class Node<V> {
        private Node<V> prev;
        private Node<V> next;
        private V value;

        Node(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setPrev(Node<V> prev) {
            this.prev = prev;
        }

        public void setNext(Node<V> next) {
            this.next = next;
        }

        public Node<V> getNext() {
            return next;
        }

        public Node<V> getPrev() {
            return prev;
        }
    }
}
