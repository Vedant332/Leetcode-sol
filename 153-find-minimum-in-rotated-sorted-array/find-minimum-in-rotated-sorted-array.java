class Solution {
    public int findMin(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        int ans=Integer.MAX_VALUE;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[lo]<=nums[mid]){
                //left sorted
                ans=Math.min(nums[lo],ans);
                lo=mid+1;
            }else{
                //right sorted
                ans=Math.min(nums[mid],ans);
                hi=mid-1;
            }
        }
        return ans;
    }
}