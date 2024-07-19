class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
       dp[n]=0;
       dp[n-1]=cost[n-1];

       for(int i=n-2;i>=0;i--){
        int oneJump = cost[i] + dp[i + 1];
        int twoJump = cost[i] + dp[i + 2];
        dp[i] = Math.min(oneJump, twoJump);
       }

        return Math.min(dp[0],dp[1]);
    }
}

    