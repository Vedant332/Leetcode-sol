class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return func(0,0,fee,prices,dp);
    }

    public int func(int ind,int buy,int fee,int[] prices,int[][] dp){
        if(ind==prices.length) return 0;

        if(dp[ind][buy]!=-1) return dp[ind][buy];

        int profit=0;
        if(buy%2==0){
            profit=Math.max(-prices[ind]+func(ind+1,1-buy,fee,prices,dp),func(ind+1,buy,fee,prices,dp));
        }else{
            profit=Math.max(prices[ind]-fee+func(ind+1,1-buy,fee,prices,dp),func(ind+1,buy,fee,prices,dp));
        }
        return dp[ind][buy]=profit;
    }
}