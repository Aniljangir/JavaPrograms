package hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImp {

    /**
     * InnerHashMapImp
     */
    public static class HashMap<K, V> { // generics

        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

        }

        int n; // Number of nodes and data
        int N; // Number of Buckets
        private LinkedList<Node> buckets[];

        HashMap() {
            N = 4; //
            buckets = new LinkedList[N];

            // Initializing empty buckets
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashIndex(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N; // if we take modules for any value then it will give us less than value
        }

        private int dataIndex(K key, int bi) {
            LinkedList<Node> ll = buckets[bi]; // geting the linkedlist of bucket index

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        void reHash() {
            N = N * 2; // increasing the size by double
            LinkedList<Node>[] oldBuckets = buckets;

            buckets = new LinkedList[N];

            // creating blank buckets
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node data = ll.get(j);
                    put(data.key, data.value);
                }
            }

        }

        void put(K key, V value) {
            int bi = hashIndex(key);
            int di = dataIndex(key, bi);

            if (di == -1) { // Key does't exist
                Node newNode = new Node(key, value);
                buckets[bi].add(newNode);
                n++;
            } else { // Key exist
                Node data = buckets[bi].get(di);
                data.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                /// rehashing
                reHash();
            }
        }

        V get(K key) {
            int bi = hashIndex(key);
            int di = dataIndex(key, bi);

            if (di == -1) {
                return null;
            } else {
                return buckets[bi].get(di).value;
            }

        }

        boolean containsKey(K key) {
            int bi = hashIndex(key);
            int di = dataIndex(key, bi);

            if (di == -1) {
                return false;
            } else {
                return true;
            }
        }

        boolean isEmpty() {
            return n == 0;
        }

        V remove(K key) {
            int bi = hashIndex(key);
            int di = dataIndex(key, bi);

            if (di == -1) {
                return null;
            } else {
                Node data = buckets[bi].get(di);
                buckets[bi].remove(di);
                n--;
                return data.value;
            }
        }

        ArrayList<K> keySet() {
            ArrayList keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Canada", 50);
        map.put("india", 100);
        map.put("Us", 80);
        map.put("Us1", 80);
        map.put("Us2", 80);
        map.put("Us3", 80);
        map.put("Us4", 80);

        ArrayList<String> ll = map.keySet();
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i) + " " + map.get(ll.get(i)));
        }

        System.err.println(map.n + "remove key:- " + map.remove("Us"));

        ArrayList<String> lll = map.keySet();
        for (int i = 0; i < lll.size(); i++) {
            System.out.println(lll.get(i) + " " + map.get(lll.get(i)));
        }
    }

}
