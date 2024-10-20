class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][4];
        
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=1;buy>=0;buy--){
                for(int cap=1;cap<=3;cap++){
                    int profit=0;
                    if(buy==0){
                        profit=Math.max(-prices[ind]+dp[ind+1][1-buy][cap],dp[ind+1][buy][cap]);
                    }else{
                        profit=Math.max(prices[ind]+dp[ind+1][1-buy][cap-1],dp[ind+1][buy][cap]);
                    }
                     dp[ind][buy][cap]=profit;
                }
            }
        }

        return dp[0][0][2];
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