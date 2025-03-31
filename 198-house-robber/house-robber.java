class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return func(nums,nums.length-1,dp);
    }

    public int func(int[] nums,int ind,int[] dp){
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1) return dp[ind];

        int take=nums[ind]+func(nums,ind-2,dp);
        int notTake=func(nums,ind-1,dp);

        return dp[ind]=Math.max(take,notTake);
    }
}