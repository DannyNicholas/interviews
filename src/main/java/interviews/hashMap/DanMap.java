package interviews.hashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An implementation of a Map supporting get() and put() methods.
 *
 * @param <K>
 * @param <V>
 */
public class DanMap<K, V> {

    public static void main(String[] args) {
        DanMap<String, Integer> map = new DanMap<>();
        map.put("Dan", 23);
        map.put("Harry", 19);
        System.out.println(map.get("Dan"));
        System.out.println(map.get("Harry"));
        map.put("Dan", 24);
        System.out.println(map.get("Dan"));
    }

    private static int BUCKETS = 10;

    // a list of buckets
    // each bucket holds a set of elements with generic keys/values
    private List<Set<Element<K, V>>> buckets;

    public DanMap() {
        buckets = new ArrayList<>(BUCKETS);
        for (int i = 0; i < BUCKETS; i++) {
            buckets.add(new HashSet<>());
        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        int bucketId = findBucket(key);
        Set<Element<K, V>> bucket = buckets.get(bucketId);
        Element<K, V> element = findElement(key, bucket);

        return (element != null) ? element.value : null;
    }

    public void put(K key, V value) {

        int bucketId = findBucket(key);
        Set<Element<K, V>> bucket = buckets.get(bucketId);
        Element<K, V> element = new Element<>(key, value);

        // remove previous element in case element with same key already exists in set
        bucket.remove(element);
        bucket.add(element);
    }


    private int findBucket(K key) {
        return key.hashCode() % BUCKETS;
    }

    private Element<K, V> findElement(K key, Set<Element<K, V>> bucket) {

        for (Element<K, V> element : bucket) {
            if (element.key.equals(key)) {
                return element;
            }
        }
        return null;
    }


    public static class Element<K, V> {

        public K key;
        public V value;

        public Element(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Element() {
            this.key = key;
            this.value = value;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object other) {
            Element<K, V> that = (Element<K, V>) other;
            return this.key.equals(that.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public String toString() {
            return key.toString() + value.toString();
        }
    }
}

