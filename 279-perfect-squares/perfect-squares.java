class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);

        dp[0]=0;

        for(int j=1;j<n+1;j++){
            int mini=Integer.MAX_VALUE;
            int ans=0;
        for(int i=1;i*i<=j;i++){
                ans=dp[j-i*i]+1;
            
            mini=Math.min(mini,ans);
        }
         dp[j]=mini;
        }
        return dp[n];
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