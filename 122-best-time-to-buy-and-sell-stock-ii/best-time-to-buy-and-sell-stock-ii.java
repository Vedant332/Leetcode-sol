class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];

        for(int ind=prices.length-1;ind>=0;ind--){
            for(int flag=1;flag>=0;flag--){
                int profit=0;
                if(flag==0){
                    int buy=-prices[ind]+dp[ind+1][1-flag];
                    int notBuy=dp[ind+1][flag];
                    profit=Math.max(buy,notBuy);
                }else{
                    int sell=prices[ind]+dp[ind+1][1-flag];
                    int notSell=dp[ind+1][flag];
                    profit=Math.max(sell,notSell);
                }
                 dp[ind][flag]=profit;
            }
        }
        
        return dp[0][0];
    }

    public int helper(int ind,int[] prices,int flag,int[][] dp){
        if(ind==prices.length) return 0;
        if(dp[ind][flag]!=-1) return dp[ind][flag];
        int profit=0;
        if(flag==0){
            int buy=-prices[ind]+helper(ind+1,prices,1-flag,dp);
            int notBuy=helper(ind+1,prices,flag,dp);
            profit=Math.max(buy,notBuy);
        }else{
            int sell=prices[ind]+helper(ind+1,prices,1-flag,dp);
            int notSell=helper(ind+1,prices,flag,dp);
            profit=Math.max(sell,notSell);
        }
        return dp[ind][flag]=profit;
    }
}