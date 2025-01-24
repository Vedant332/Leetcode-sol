class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int[] row : dp ){
            Arrays.fill(row,-1);
        }
        return helper(0,prices,0,dp);
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