class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        
        for(int am=0;am<=amount;am++){
            if(am%coins[0]==0){
                dp[0][am]=am/coins[0];
            }else{
                dp[0][am]=(int) Math.pow(10, 9);
            }
        }

        for(int ind=1;ind<coins.length;ind++){
            for(int am=0;am<=amount;am++){
                int notTake=dp[ind-1][am];
                int take=Integer.MAX_VALUE;
                if(coins[ind]<=am) take=1+dp[ind][am-coins[ind]];

                dp[ind][am]=Math.min(take,notTake);
            }
        }
         int ans=dp[coins.length-1][amount];
         if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    public int func(int[] nums,int ind,int amount,int[][] dp){
        if(ind==0){
            if(amount%nums[ind]==0){
                return amount/nums[ind];
            }else{
                return (int) Math.pow(10, 9);
            }
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        int notTake=func(nums,ind-1,amount,dp);
        int take=Integer.MAX_VALUE;
        if(nums[ind]<=amount) take=1+func(nums,ind,amount-nums[ind],dp);

        return dp[ind][amount]=Math.min(take,notTake);
    }
}