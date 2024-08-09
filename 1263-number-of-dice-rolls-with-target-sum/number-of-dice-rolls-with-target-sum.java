class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(n,k,0,target,dp);
    }

    public int helper(int n,int k,int sumTillNow,int target,int[][] dp){
        if(n == 0){
            if (sumTillNow == target ) return 1;
            else return 0;
        }
        if(dp[n][sumTillNow]!=-1) return dp[n][sumTillNow];
        int count = 0;
        for(int i=1;i<=k;i++){
            if (sumTillNow + i <= target) {
                count += helper(n - 1, k, sumTillNow + i, target, dp);
                count %= 1_000_000_007; 
            }
        }

        return dp[n][sumTillNow]=count;
    }
}