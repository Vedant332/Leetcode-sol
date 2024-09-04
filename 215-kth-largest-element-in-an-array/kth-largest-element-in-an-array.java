class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->x-y);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        while(pq.size()!=k){
            pq.poll();
        }

        int ans=pq.poll();
        return ans;

    }
}