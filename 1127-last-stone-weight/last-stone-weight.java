class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)-> Integer.compare(b,a));

        for(int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }

        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();

            int difference=a-b;
            pq.offer(difference);
        }
        return pq.poll();
    }
}