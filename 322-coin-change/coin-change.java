class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans=helper(coins,n-1,amount,dp);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    public int helper(int[] coins,int ind,int amount,int[][] dp){
        if(ind==0){
            if(amount%coins[ind]==0) return amount/coins[ind];
            else return (int) Math.pow(10, 9);
        }
        

        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int notTake=helper(coins,ind-1,amount,dp);
        int take=Integer.MAX_VALUE;
        if(coins[ind]<=amount){
            take=1+helper(coins,ind,amount-coins[ind],dp);
        }

        return dp[ind][amount]=Math.min(take,notTake);
    }
}