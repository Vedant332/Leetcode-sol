class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for(int[][] d : dp){
            for(int[] row : d){
                Arrays.fill(row,-1);
            }
        }

        return helper(0,0,2,prices,dp);
    }

    public int helper(int ind,int buy,int cap,int[] prices,int[][][] dp){
        if(cap==0) return 0;
        if(ind==prices.length) return 0;

        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];

        int profit=0;
        if(buy==0){
            profit=Math.max(-prices[ind]+helper(ind+1,1-buy,cap,prices,dp),helper(ind+1,buy,cap,prices,dp));
        }else{
            profit=Math.max(prices[ind]+helper(ind+1,1-buy,cap-1,prices,dp),helper(ind+1,buy,cap,prices,dp));
        }
        return dp[ind][buy][cap]=profit;
    }
}