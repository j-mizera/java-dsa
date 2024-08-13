package eu.witherxse.dsa.map;

public interface SimpleMap<K, V> {

        /**
        * Adds key-value pair to the map.
        * @param key
        * @param value
        */
        void put(K key, V value);

        /**
        * Returns value for given key.
        * @param key
        * @return value
        */
        V get(K key);

        /**
        * Removes key-value pair from the map.
        * @param key
        */
        void remove(K key);

        /**
        * Returns true if map contains key.
        * @param key
        * @return
        */
        boolean contains(K key);
}
