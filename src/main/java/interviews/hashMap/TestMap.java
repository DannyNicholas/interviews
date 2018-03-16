package interviews.hashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestMap {

    public static void main(String[] args) {

        MyMap<Integer, String> myMap = new MyMap<>();
        System.out.println(myMap.get(23));
        myMap.put(23, "hello");
        System.out.println(myMap.get(23));
        myMap.put(23, "george");
        System.out.println(myMap.get(23));

    }

    public static class MyMap<K, V> {

        private static final int NUM_BUCKETS = 16;
        private final List<Set<Element<K, V>>> buckets;

        public MyMap() {
            this.buckets = new ArrayList<>(NUM_BUCKETS);
            for (int i = 0; i < NUM_BUCKETS; i++) {
                buckets.add(new HashSet<>());
            }
        }

        public V get(K key) {
            Set<Element<K, V>> bucket = findBucket(key);

            for (Element<K, V> element : bucket) {
                if (element.key.equals(key)) {
                    return element.value;
                }
            }

            return null;
        }

        public void put(K key, V value) {

            Element<K, V> element = new Element(key, value);
            Set<Element<K, V>> bucket = findBucket(key);
            bucket.remove(element);
            bucket.add(element);
        }


        private Set<Element<K, V>> findBucket(K key) {
            int bucketNum = key.hashCode() % NUM_BUCKETS;
            return buckets.get(bucketNum);
        }
    }

    public static class Element<K, V> {
        public K key;
        public V value;

        public Element(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            Element<K, V> that = (Element<K, V>) obj;
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
