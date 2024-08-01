class Solution {
    int mod = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp=new int[high +1];
        Arrays.fill(dp,-1);
        return helper(low,high,zero,one,0,dp);
    }

    public int helper(int low,int high,int zero,int one,int curr,int[] dp){
        if(curr>high) return 0;

        if(dp[curr]!=-1) return dp[curr];

        int res = 0;
        if(low <= curr && curr <= high){
            res += 1;
        }
        int takeZero=helper(low,high,zero,one,curr+zero,dp);
        int takeOne=helper(low,high,zero,one,curr+one,dp);

        return dp[curr]=(res+takeZero+takeOne)%mod;
    }
}