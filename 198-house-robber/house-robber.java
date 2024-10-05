class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);

        return helper(nums,nums.length-1,dp);
    }

    public int helper(int[] nums,int ind,int[] dp){
        if(ind==0) return nums[ind];
        if(dp[ind]!=-1) return dp[ind];
        int notTake=helper(nums,ind-1,dp);
        int take=nums[ind];
        if(ind>1){
            take+=helper(nums,ind-2,dp);
        }
        return dp[ind]=Math.max(take,notTake);
    }
}