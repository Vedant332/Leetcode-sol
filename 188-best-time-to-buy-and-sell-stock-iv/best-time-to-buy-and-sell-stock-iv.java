class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2*k+1];
        
        for(int ind=n-1;ind>=0;ind--){
            for(int trans=2*k-1;trans>=0;trans--){
                int profit=0;
                if(trans%2==0){
                    profit=Math.max(dp[ind+1][trans],-prices[ind]+dp[ind+1][trans+1]);
                }else{
                    profit=Math.max(dp[ind+1][trans],prices[ind]+dp[ind+1][trans+1]);
                }
                 dp[ind][trans]=profit;
            }
        }

        return dp[0][0];
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