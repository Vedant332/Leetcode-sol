class MedianFinder {
    PriorityQueue<Integer> leftMax;
    PriorityQueue<Integer> rightMin;

    public MedianFinder() {
        leftMax=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        rightMin=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (leftMax.isEmpty()) {
            leftMax.offer(num);
        } else {
            if (leftMax.peek() < num) {
                rightMin.offer(num);

                if (rightMin.size() > leftMax.size()) {
                    leftMax.offer(rightMin.poll());
                }
            } else {
                leftMax.offer(num);
            }

            // This needs to be outside the above if/else
            if (leftMax.size() > rightMin.size() + 1) {
                rightMin.offer(leftMax.poll());
            }
        }
    }
    
    public double findMedian() {
        double median=0;
        if(leftMax.size()>rightMin.size()){
            median=leftMax.peek();
        }else{
            median=(leftMax.peek()+rightMin.peek())/2.0;
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