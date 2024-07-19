class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+2];
       dp[n+1]=0;
       dp[n]=0;

       for(int i=n-1;i>=0;i--){
        int oneJump = cost[i] + dp[i + 1];
        int twoJump = cost[i] + dp[i + 2];
        dp[i] = Math.min(oneJump, twoJump);
       }

        return Math.min(dp[0],dp[1]);
    }

    private int helper(int ind, int[] cost, int[] memo) {
        if (ind >= cost.length) {
            return 0;
        }
        if (memo[ind] != -1) {
            return memo[ind];
        }
        int oneJump = cost[ind] + helper(ind + 1, cost, memo);
        int twoJump = cost[ind] + helper(ind + 2, cost, memo);
        memo[ind] = Math.min(oneJump, twoJump);
        return memo[ind];
    }
}