class Node{
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        next=null;
        prev=null;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer,Node> map=new HashMap<>();
    Node head=new Node(0,0);
    Node tail=new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            removeNode(node);
            insertAthead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            removeNode(node);
            insertAthead(node);
        }else{
            if(map.size()==capacity){
                Node node=tail.prev;
                map.remove(node.key);
                removeNode(node);
            }

            Node node=new Node(key,value);
            map.put(node.key,node);
            insertAthead(node);
        }
    }

    public void removeNode(Node node){
        Node prevNode=node.prev;
        Node afterNode=node.next;
        prevNode.next=afterNode;
        afterNode.prev=prevNode;
        node.prev = null;
node.next = null;
    }

    public void insertAthead(Node node){
        Node afterNode=head.next;
        head.next=node;
        node.prev=head;
        node.next=afterNode;
        afterNode.prev=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */