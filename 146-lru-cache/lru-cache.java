class Node{
     int key, val;
    Node prev, next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        prev=null;
        next=null;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int ans=map.get(key).val;
            removeNode(map.get(key));
            insertAthead(map.get(key));
            return ans;
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
                removeNode(node);
                map.remove(node.key);
            }
             Node newNode=new Node(key,value);
                map.put(key,newNode);
                insertAthead(newNode);
        }
    }

    public void insertAthead(Node node){
         Node afterNode=head.next;
        node.next=head.next;
        node.prev=head;
        afterNode.prev=node;
        head.next=node;
    }

    public void removeNode(Node node){
       Node after=node.next;
       Node previous=node.prev;
       previous.next=after;
       after.prev=previous;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */