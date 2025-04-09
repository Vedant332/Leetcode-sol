class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
         int ans=func(coins,coins.length-1,amount,dp);
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