package customDS;

import java.util.LinkedList;

public class HashMapMain {
    static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            public HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<HMNode>[] buckets;
        private int size;

        public HashMap() {
            buckets = new LinkedList[4];
            size = 0;
            initializeHashMap();
        }

        private void initializeHashMap() {
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public void put(K key, V value) {
            int bi = getBucketIndex(key);
            int di = getElementIndex(key, bi);

            if (di == -1) {
                HMNode newNode = new HMNode(key, value);
                buckets[bi].add(newNode);
                size++;
            } else {
                HMNode current = buckets[bi].get(di);
                current.value = value;
            }

            double lambda = size * 1.0 / buckets.length;

            if (lambda > 2.0) {
                rehash();
            }

        }

        private void rehash() {
            LinkedList<HMNode>[] origBuckets = buckets;
            buckets = new LinkedList[2 * buckets.length];
            initializeHashMap();

            for (int i = 0; i < origBuckets.length; i++) {
                for (HMNode node : origBuckets[i]) {
                    put(node.key, node.value);
                }
            }
        }

        public V get(K key) {
            int bi = getBucketIndex(key);
            int di = getElementIndex(key, bi);

            if (di == -1) {
                return null;
            } else {
                HMNode current = buckets[bi].get(di);
                return current.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = getBucketIndex(key);
            int di = getElementIndex(key, bi);

            if (di == -1) {
                return false;
            } else {
                return true;
            }
        }

        public void remove(K key) {
            int bi = getBucketIndex(key);
            int di = getElementIndex(key, bi);

            if (di != -1) {
                buckets[bi].remove(di);
                size--;
            }
        }

        private int getElementIndex(K key, int bi) {
            int di = 0;
            for (HMNode node : buckets[bi]) {
                if (node.key.equals(key)) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        private int getBucketIndex(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "DC");
        hashMap.put(2, "AC");
        hashMap.put(3, "LC");
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(4));
        hashMap.put(3, "AM");
        System.out.println(hashMap.get(3));
        hashMap.remove(1);
        System.out.println(hashMap.get(1));
    }
}
