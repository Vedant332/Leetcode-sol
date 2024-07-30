class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] dp=new boolean[nums.length+1];
        return func(nums ,nums.length,dp);
    }

    public boolean func(int[] nums,int ind,boolean[] dp){
        if(ind==0){
            return true;
        }

        if(dp[ind]!=false) return dp[ind];

        if(ind>=2 && nums[ind-2]==nums[ind-1] && func(nums,ind-2,dp)){
            return dp[ind]=true;
        }
        if(ind>=3 && (nums[ind-3]==nums[ind-2] && nums[ind-2]==nums[ind-1]||nums[ind - 3] == nums[ind - 2] - 1 && nums[ind - 2] == nums[ind - 1] - 1)
                && func(nums, ind - 3,dp)){
                    return dp[ind]=true;
                }
                return dp[ind]=false;
    }
}