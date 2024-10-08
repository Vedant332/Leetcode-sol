class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i]=(int) Math.pow(10, 9);
            }
        }

        for(int ind=1;ind<n;ind++){
            for(int am=0;am<=amount;am++){
                int notTake=dp[ind-1][am];
                 int take=Integer.MAX_VALUE;
                if(coins[ind]<=am){
                    take=1+dp[ind][am-coins[ind]];
                }
                 dp[ind][am]=Math.min(take,notTake);
            }
        }
        int ans=dp[n-1][amount];
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