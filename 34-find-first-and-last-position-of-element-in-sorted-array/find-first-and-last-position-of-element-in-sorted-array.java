class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo=0;
        int hi=nums.length-1;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(nums[mid]==target){
                int start=mid;
                int end=mid;
                while( start-1>=0 && nums[start]==nums[start-1]){
                    start--;
                }
                while(end+1<nums.length && nums[end]==nums[end+1]){
                    end++;
                }
                return new int[]{start,end};
            }else if(nums[mid]<target){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}