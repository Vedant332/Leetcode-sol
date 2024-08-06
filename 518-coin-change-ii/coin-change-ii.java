class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(amount,coins.length-1,coins,dp);
    }

    public int helper(int amount,int ind,int[] coins,int[][] dp){
        if(ind==0){
            if(amount%coins[ind]==0){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        int take=0;
        if(coins[ind]<=amount){
            take=helper(amount-coins[ind],ind,coins,dp);
        }
        int notTake=helper(amount,ind-1,coins,dp);

        return dp[ind][amount]=take+notTake;
    }
}