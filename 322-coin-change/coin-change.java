class Solution {
    public int coinChange(int[] coins, int amount) {
       int n = coins.length;
         int[][] dp = new int[n][amount + 1];
        for(int i=0;i<amount+1;i++){
           if (i % coins[0] == 0)
                dp[0][i]=i / coins[0];
            else
                dp[0][i]=(int) Math.pow(10, 9);
        }
        for(int ind=1;ind<n;ind++){
            for(int j=0;j<amount+1;j++){
                int take= (int) Math.pow(10, 9);
        if(coins[ind]<=j){
            take=1+dp[ind][j-coins[ind]];
        }
        int notTake=dp[ind-1][j];

         dp[ind][j]=Math.min(take,notTake);
            }
        }
        return dp[n - 1][amount] >= (int) Math.pow(10, 9) ? -1 : dp[n - 1][amount];
    }

     public int solve(int[] coins,int ind,int amount,int[][] dp){
         if (ind == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            else
                return (int) Math.pow(10, 9);
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        int take= Integer.MAX_VALUE;
        if(coins[ind]<=amount){
            take=1+solve(coins,ind,amount-coins[ind],dp);
        }
        int notTake=solve(coins,ind-1,amount,dp);

        return dp[ind][amount]=Math.min(take,notTake);
    }
}