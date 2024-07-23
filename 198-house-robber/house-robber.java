class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int take = nums[i] + dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[nums.length - 1];
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