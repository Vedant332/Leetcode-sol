class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(0,0,prices,dp);
    }

    public int func(int ind,int buy,int[] prices,int[][] dp){
        if(ind>=prices.length) return 0;

        if(dp[ind][buy]!= -1) return dp[ind][buy];
        
        int profit=0;
        if(buy%2==0){
            profit=Math.max(-prices[ind]+func(ind+1,1-buy,prices,dp),func(ind+1,buy,prices,dp));
        }else{
            profit=Math.max(prices[ind]+func(ind+2,1-buy,prices,dp),func(ind+1,buy,prices,dp));
        }
        return dp[ind][buy]=profit;
    }
}