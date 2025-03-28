class MedianFinder {
    PriorityQueue<Integer> left_max_heap;
    PriorityQueue<Integer> right_min_heap;
    public MedianFinder() {
     left_max_heap=new PriorityQueue<>(Comparator.reverseOrder());   
     right_min_heap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left_max_heap.isEmpty() || left_max_heap.peek()>num){
            left_max_heap.add(num);
        }else{
            right_min_heap.add(num);
        }

        if(Math.abs(left_max_heap.size()-right_min_heap.size())>1){
            right_min_heap.add(left_max_heap.peek());
            left_max_heap.remove();
        }else if(right_min_heap.size()>left_max_heap.size()){
            left_max_heap.add(right_min_heap.peek());
            right_min_heap.remove();
        }
    }
    
    public double findMedian() {
        double median;
        if(right_min_heap.size()==left_max_heap.size()){
            median=(double)(right_min_heap.peek()+left_max_heap.peek())/2;
        }else{
            median=(double)left_max_heap.peek();
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */