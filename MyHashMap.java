import java.util.*;

public class MyHashMap<K,V> {

    private int sizeHashMap;
    HashNode<K,V> first;
    HashNode<K,V> last;

    private class HashNode<K,V>{
        K key;
        V value;
        int hash;
        HashNode<K,V> next;


        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = Objects.hash(key);
        }
    }

    public void put(K key, V value) {
        int hashKey = Objects.hash(key);
        HashNode<K,V> lastNode = last;
        HashNode<K,V> newElement = new HashNode<>(key, value);
        boolean ismatch = false;
        for (HashNode<K, V> x = first; x != null; ) {
            if (hashKey == x.hash) {
                x.value = value;
                ismatch = true;
            }

            x = x.next;
        }
        if (!ismatch) {
            if (first == null) {
                first = newElement;
            }
            else{
                lastNode.next = newElement;
            }
            last = newElement;
            sizeHashMap++;
        }

    }

    public void remove(Object key) {
        int hashKey = Objects.hash(key);
        HashNode<K,V> removeNext;
        for (HashNode<K,V> x = first; x != null;){
            removeNext = x;
            if (hashKey == x.next.hash){
                removeNext.next = x.next.next;
                x.next.value = null;
                x.next.key = null;
                x.next.next = null;
                x.next.hash = 0;
                break;
            }
            x = x.next;
        }
    }

    public void clear() {
        first = null;
        last = null;
        sizeHashMap = 0;
    }

    public int size() {
        return sizeHashMap;
    }

    public V get(K key) {
        int hashKey = Objects.hash(key);
        V searchValue = null;
        for (HashNode<K,V> x = first; x != null;){
            if (hashKey == x.hash){
                searchValue = x.value;
            }
            x=x.next;
        }
        return searchValue;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> myMap = new MyHashMap<>();
        myMap.put(0,1);
        myMap.put(1,2);
        myMap.put(3,4);
        myMap.put(5,6);
        myMap.put(6,4);
        myMap.remove(3);
        System.out.println(myMap.size());
        System.out.println(myMap.get(1));
        System.out.println(myMap.get(0));
        myMap.clear();
    }
}