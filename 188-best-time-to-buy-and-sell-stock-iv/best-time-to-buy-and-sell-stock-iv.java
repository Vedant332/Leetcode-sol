class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2*k];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(0,0,k,prices,dp);
    }

    public int func(int ind,int trans,int k,int[] prices,int[][] dp){
        if(ind==prices.length || trans==2*k) return 0;

        if(dp[ind][trans]!=-1) return dp[ind][trans];

        int profit=0;
        if(trans%2==0){
            profit=Math.max(func(ind+1,trans,k,prices,dp),-prices[ind]+func(ind+1,trans+1,k,prices,dp));
        }else{
            profit=Math.max(func(ind+1,trans,k,prices,dp),prices[ind]+func(ind+1,trans+1,k,prices,dp));
        }
        return dp[ind][trans]=profit;
    }
}