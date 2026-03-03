class Solution {
    public int findPeakElement(int[] nums) {
        int lo=1;
        int hi=nums.length-2;

        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[hi]<nums[hi+1]) return hi+1;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1]) lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
}