class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo=0;
        int hi=nums.length-1;
        int left=0;
        int right=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(nums[mid]==target){
                left=mid;
                right=mid;
                while(left>0 && nums[mid]==nums[left-1]){
                    left--;
                }
                while(right<nums.length-1 && nums[mid]==nums[right+1]){
                    right++;
                }
                return new int[]{left,right};
            }else if(nums[mid]<target){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}