class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        //0->buy
        //1->sell
        return helper(0,0,prices,dp);
    }

    public int helper(int ind,int flag,int[] prices,int[][] dp){
        if(ind==prices.length) return 0;

        int profit=0;

        if(dp[ind][flag]!=-1) return dp[ind][flag];
        if(flag==0){
            int buy=-prices[ind]+helper(ind+1,1-flag,prices,dp);
            int notBuy=helper(ind+1,flag,prices,dp);
            profit=Math.max(buy,notBuy);
        }else{
            int sell=prices[ind]+helper(ind+1,1-flag,prices,dp);
            int notSell=helper(ind+1,flag,prices,dp);
            profit=Math.max(sell,notSell);
        }

        return dp[ind][flag]=profit;
    }
}