import java.util.*;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;
        }
    }

    class DLL {
        Node head = new Node(0,0);
        Node tail = new Node(0,0);
        int size = 0;

        DLL() {
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if(size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    Map<Integer, Node> keyMap = new HashMap<>();
    Map<Integer, DLL> freqMap = new HashMap<>();

    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;

        Node node = keyMap.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {

        if(capacity == 0) return;

        if(keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            update(node);
            return;
        }

        if(keyMap.size() == capacity) {
            DLL list = freqMap.get(minFreq);
            Node removed = list.removeLast();
            keyMap.remove(removed.key);
        }

        Node node = new Node(key,value);
        keyMap.put(key,node);

        minFreq = 1;

        freqMap.putIfAbsent(1,new DLL());
        freqMap.get(1).add(node);
    }

    private void update(Node node) {

        int freq = node.freq;
        DLL list = freqMap.get(freq);

        list.remove(node);

        if(freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap.putIfAbsent(node.freq,new DLL());
        freqMap.get(node.freq).add(node);
    }
}