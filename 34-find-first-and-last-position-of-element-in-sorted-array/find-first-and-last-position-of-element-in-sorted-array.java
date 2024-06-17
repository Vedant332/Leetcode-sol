class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo=0;
        int hi=nums.length-1;
        int left=0;
        int right=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
             if (nums[mid] == target) {
                left = mid;
                right = mid;
                
                // Expand to the left and right to find the actual bounds
                while (left > 0 && nums[left - 1] == target) {
                    left--;
                }
                while (right < nums.length - 1 && nums[right + 1] == target) {
                    right++;
                }
                return new int[] {left, right};

            }else if(nums[mid]>target){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return new int[] {-1,-1};
    }
}