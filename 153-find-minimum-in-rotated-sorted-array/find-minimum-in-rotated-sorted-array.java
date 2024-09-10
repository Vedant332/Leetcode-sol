class Solution {
    public int findMin(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        int ans=Integer.MAX_VALUE;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>=nums[lo]){
                ans=Math.min(ans,nums[lo]);
                lo=mid+1;
            }else{
                ans=Math.min(ans,nums[mid]);
                hi=mid-1;
            }
        }
        return ans;
    }
}