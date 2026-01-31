class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq =new PriorityQueue<>();

        for(int ch : nums){
            pq.add(ch);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}