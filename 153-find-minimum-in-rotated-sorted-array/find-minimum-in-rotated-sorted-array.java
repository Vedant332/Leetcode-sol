class Solution {
    public int findMin(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        int min=Integer.MAX_VALUE;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            if(nums[lo]<=nums[mid]){
                min=Math.min(nums[lo],min);
                lo=mid+1;
            }else{
                min=Math.min(nums[mid],min);
                hi=mid-1;
            }
        }
        return min;
    }
}