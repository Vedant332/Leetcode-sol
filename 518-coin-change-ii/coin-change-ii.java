class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        for(int i=0;i<amount+1;i++){
            if(i % coins[0]==0){
                dp[0][i]=1;
            }
        }

        for(int ind=1;ind<n;ind++){
            for(int cost=0;cost<amount+1;cost++){
                int take=0;
             if(coins[ind]<=cost){
            take=dp[ind][cost-coins[ind]];
        }
         int notTake=dp[ind-1][cost];

         dp[ind][cost]=take+notTake;
            }
        }
        return dp[n-1][amount];
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