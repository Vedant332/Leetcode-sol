class Solution {
    public boolean validPartition(int[] nums) {
        return func(nums ,nums.length);
    }

    public boolean func(int[] nums,int ind){
        if(ind==0){
            return true;
        }

        if(ind>=2 && nums[ind-2]==nums[ind-1] && func(nums,ind-2)){
            return true;
        }
        if(ind>=3 && (nums[ind-3]==nums[ind-2] && nums[ind-2]==nums[ind-1]||nums[ind - 3] == nums[ind - 2] - 1 && nums[ind - 2] == nums[ind - 1] - 1)
                && func(nums, ind - 3)){
                    return true;
                }
                return false;
    }
}