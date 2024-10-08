class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        int ans=func(coins,n-1,amount,dp);
        
        return ans;
    }

    public int func(int[] coins,int ind,int cost,int[][] dp){
         if (ind == 0) {
            if (cost % coins[ind] == 0) return 1;
            return 0;  
        }
       

        if(dp[ind][cost]!=-1) return dp[ind][cost];
        int notTake=func(coins,ind-1,cost,dp);
        int take=0;
        if(coins[ind]<=cost){
            take=func(coins,ind,cost-coins[ind],dp);
        }

        return dp[ind][cost]=take+notTake;
    }
}