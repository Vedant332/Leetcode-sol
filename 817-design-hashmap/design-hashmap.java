class Pair{
    int key;
    int val;
    public Pair(int key, int val){
        this.key=key;
        this.val=val;
    }
}

class MyHashMap {
    private List<Pair>[] bucket;
    private int size = 10000;

    public MyHashMap() {
        bucket=new LinkedList[size];
        for(int i=0;i<size;i++){
             bucket[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        int bucket_no=key%size;
        List<Pair> chain=bucket[bucket_no];
        for(Pair it : chain){
            if(it.key==key){
                it.val=value;
                return;
            }
        }
        chain.add(new Pair(key, value)); ;
        
    }
    
    public int get(int key) {
         int bucketNo = key % size;
        List<Pair> chain = bucket[bucketNo];
        for (Pair pair : chain) {
            if (pair.key == key) {
                return pair.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucketNo = key % size;
        List<Pair> chain = bucket[bucketNo];
        for (Pair pair : chain) {
            if (pair.key == key) {
                chain.remove(pair);
                return;

    }
}
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */