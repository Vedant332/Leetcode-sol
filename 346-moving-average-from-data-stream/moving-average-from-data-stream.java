class MovingAverage {
    Queue<Integer> q;
    int size;
    double sum;
    public MovingAverage(int size) {
        q=new LinkedList<>();
        this.size=size;
    }
    
    public double next(int val) {
        if(q.size()==size){
            sum-=q.poll();
            q.offer(val);
        }else{
            q.offer(val);
        }
        sum+=val;
        return (1.0*sum)/q.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */