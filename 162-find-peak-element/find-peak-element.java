class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        int lo=1;
        int hi=nums.length-2;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }else{
                if(nums[mid]<nums[mid+1]){
                    lo=mid+1;
                }else if(nums[mid]<nums[mid-1]){
                    hi=mid-1;
                }
            }
        }
        return -1;
    }
}