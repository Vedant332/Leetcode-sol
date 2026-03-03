class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo=1;
        int hi=nums.length-2;

        if(nums.length == 1) return nums[0];
        if(nums[lo]!=nums[lo-1]) return nums[lo-1];
        if(nums[hi]!=nums[hi+1]) return nums[hi+1];

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            else if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1])) lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
}