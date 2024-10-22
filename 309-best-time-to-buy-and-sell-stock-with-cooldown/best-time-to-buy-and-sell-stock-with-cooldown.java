class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+2][2];
        
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=1;buy>=0;buy--){
                    int profit=0;
                if(buy%2==0){
                    profit=Math.max(-prices[ind]+dp[ind+1][1-buy],dp[ind+1][buy]);
                }else{
                    profit=Math.max(prices[ind]+dp[ind+2][1-buy],dp[ind+1][buy]);
                }
                 dp[ind][buy]=profit;
           }
        }

        return dp[0][0];
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