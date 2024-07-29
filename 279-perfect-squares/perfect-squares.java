class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }

    public int helper(int n,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];

        int mini=Integer.MAX_VALUE;
        int ans=0;
        for(int i=1;i*i<=n;i++){
            ans=helper(n-i*i,dp)+1;
            mini=Math.min(mini,ans);
        }
        return dp[n]=mini;
    }
}