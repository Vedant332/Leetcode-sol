class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(prices,0,1,dp);
    }

    public int helper(int[] prices,int ind,int cooldown,int[][] dp){
        if(ind>=prices.length) return 0;

        if(dp[ind][cooldown]!=-1) return dp[ind][cooldown];
        if(cooldown==1){
            return dp[ind][cooldown]=Math.max(helper(prices,ind+1,1,dp),-prices[ind]+helper(prices,ind+1,0,dp));
        }else{
            return dp[ind][cooldown]=Math.max(prices[ind]+helper(prices,ind+2,1,dp),helper(prices,ind+1,0,dp));
        }
    }
}