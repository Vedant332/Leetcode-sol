class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return func(nums.length-1,nums,dp);
    }

    public int func(int ind,int[] nums,int[] dp){
        if(ind<=0){
            if(ind<0){
                return 0;
            }
            return nums[0];
        }

        if(dp[ind]!=-1) return dp[ind];

        int take=nums[ind]+func(ind-2,nums,dp);
        int notTake=func(ind-1,nums,dp);

        return dp[ind]=Math.max(take,notTake);

    }
}