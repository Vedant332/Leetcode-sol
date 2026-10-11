class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];

        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int ind=2;ind<cost.length;ind++){
             int one=dp[ind-1];
             int two=dp[ind-2];

             dp[ind]=cost[ind]+Math.min(one,two);
        }
        return Math.min(dp[cost.length - 1],dp[cost.length - 2]);
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