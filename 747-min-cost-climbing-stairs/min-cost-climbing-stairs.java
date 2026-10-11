class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(
    helper(cost.length - 1, cost,dp),
    helper(cost.length - 2, cost,dp)
);
    }

    public int helper(int ind,int[] cost,int[] dp){
            if(ind<0) return Integer.MAX_VALUE;
            if(ind==1) return cost[1];
            if(ind==0) return cost[0];
            if(dp[ind]!=-1) return dp[ind];
        int one=helper(ind-1,cost,dp);
        int two=helper(ind-2,cost,dp);

        return dp[ind]=cost[ind]+Math.min(one,two);
    }
}