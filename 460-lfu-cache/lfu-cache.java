class Node {
    int key, val, freq;
    Node prev, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1; 
    }
}

class DoublyLinkedList {
    Node head, tail;
    int size;

    public DoublyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeLast() {
        if (size > 0) {
            Node last = tail.prev;
            removeNode(last);
            return last;
        }
        return null;
    }
}

class LFUCache {
    int capacity;
    int currSize;
    int minFreq;
    Map<Integer, Node> cache; // key -> node
    Map<Integer, DoublyLinkedList> freqMap; // freq -> list of nodes

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            updateNode(node);
        } else {
            if (currSize == capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                Node toRemove = minFreqList.removeLast();
                cache.remove(toRemove.key);
                currSize--;
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            freqMap.putIfAbsent(1, new DoublyLinkedList());
            freqMap.get(1).addNode(newNode);
            currSize++;
            minFreq = 1;
        }
    }

    private void updateNode(Node node) {
        int freq = node.freq;
        DoublyLinkedList list = freqMap.get(freq);
        list.removeNode(node);

        if (freq == minFreq && list.size == 0)
            minFreq++;

        node.freq++;
        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());
        freqMap.get(node.freq).addNode(node);
    }
}