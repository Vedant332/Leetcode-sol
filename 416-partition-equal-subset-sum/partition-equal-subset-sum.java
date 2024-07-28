class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) return false;

        int sum = totalSum / 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true; 
        }

        for (int ind = 1; ind <= nums.length; ind++) {
            for (int j = 1; j <= sum; j++) {
                boolean notTake = dp[ind - 1][j];
                boolean take = false;
                if (j >= nums[ind - 1]) {
                    take = dp[ind - 1][j - nums[ind - 1]];
                }
                dp[ind][j] = take || notTake;
            }
        }

        return dp[nums.length][sum];
    }

    public boolean helper(int[] nums,int sum,int ind,boolean[][] dp){
        if(ind==nums.length){
            if(sum==0) return true;
            else return false;
        }

        if(dp[ind][sum]!=false) return dp[ind][sum];

        boolean take=false;
        if(sum>=nums[ind]){
            take=helper(nums,sum-nums[ind],ind+1,dp);
        }
        boolean notTake=helper(nums,sum,ind+1,dp);

        return dp[ind][sum]=take|notTake;
    }
}