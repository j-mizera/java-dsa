package eu.witherxse.dsa.map;

import java.util.Objects;

/**
 * Simple hash map implementation with resizing included.
 * In newer java versions maps are implemented with red-black trees for better performance.
 *
 * @param <K>
 * @param <V>
 */
public class SimpleHashMap<K, V> implements SimpleMap<K, V> {

    private static final int INITIAL_SIZE = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node<K, V>[] hashTable;
    private int tableSize;

    public SimpleHashMap() {
        this.hashTable = new Node[INITIAL_SIZE];
        this.tableSize = INITIAL_SIZE;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> node = this.getKeyNode(key);
        if (Objects.nonNull(node)) {
            node.setValue(value);
        } else {
            addNewNode(key, value);
        }
    }

    @Override
    public V get(K key) {
        Node<K, V> node = this.getKeyNode(key);
        return Objects.nonNull(node) ? node.getValue() : null;
    }

    @Override
    public void remove(K key) {
        int keyHash = this.getKeyHash(key);
        Node<K, V> potentialNode = this.hashTable[keyHash];
        if (Objects.equals(potentialNode.getKey(), key)) {
            this.hashTable[keyHash] = potentialNode.getNext();
        } else {
            Node<K, V> parentNode = this.getParentNode(key);
            if (Objects.nonNull(parentNode) && Objects.nonNull(parentNode.getNext())) {
                parentNode.setNext(parentNode.getNext().getNext());
            }
        }
    }

    @Override
    public boolean contains(K key) {
        return Objects.nonNull(this.getKeyNode(key));
    }

    private void addNewNode(K key, V value) {
        int keyHash = this.getKeyHash(key);
        Node<K, V> preNode = this.getParentNode(key);
        Node<K, V> newNode = new Node<>(key, value);
        if (Objects.nonNull(preNode)) {
            preNode.setNext(newNode);
        } else {
            this.hashTable[keyHash] = newNode;
        }
    }

    private Node<K, V> getParentNode(K key) {
        int keyHash = this.getKeyHash(key);
        Node<K, V> preNode = this.hashTable[keyHash];
        int count = 0;
        while (Objects.nonNull(preNode) && Objects.nonNull(preNode.getNext())
                && !Objects.equals(preNode.getNext().getKey(), key)) {
            preNode = preNode.getNext();
            count++;
        }
        if (count > this.tableSize * LOAD_FACTOR) {
            this.rehash();
        }
        return preNode;
    }

    private Node<K, V> getKeyNode(K key) {
        int keyHash = this.getKeyHash(key);
        Node<K, V> result = this.hashTable[keyHash];
        while (Objects.nonNull(result) && !Objects.equals(result.getKey(), key)) {
            result = result.getNext();
        }
        return result;
    }

    private int getKeyHash(K key) {
        int hash = 0;
        if (Objects.nonNull(key)) {
            hash = (key.hashCode() & 0x7fffffff) % this.tableSize;
        }
        return hash;
    }

    private void rehash() {
        Node<K, V>[] oldTable = this.hashTable;
        this.tableSize *= 2;
        this.hashTable = new Node[this.tableSize];
        for (Node<K, V> node : oldTable) {
            while (Objects.nonNull(node)) {
                this.addNewNode(node.getKey(), node.getValue());
                node = node.getNext();
            }
        }
    }

    private static class Node<K, V> {

        private K key;
        private V value;
        private Node<K, V> next;

        Node(K key, V val) {
            this.key = key;
            this.value = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public Node<K, V> getNext() {
            return next;
        }
    }
}
