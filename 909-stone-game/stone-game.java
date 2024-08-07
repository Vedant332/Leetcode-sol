class Solution {
    public boolean stoneGame(int[] piles) {
        int sum=0;
        for(int it : piles){
            sum+=it;
        }
        int n=sum/2;
        int[][] dp=new int[piles.length][piles.length];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int alexSum=helper(piles,0,piles.length-1,piles.length/2,dp);

        if(alexSum>n){
            return true;
        }

        return false;
    }

    public int helper(int[] piles,int start,int end,int turns,int[][] dp){
        if(turns==0) return 0;
        if(dp[start][end]!=-1) return dp[start][end];
        return dp[start][end]=Math.max(piles[start]+helper(piles,start+1,end,turns-1,dp),piles[end]+helper(piles,start,end-1,turns-1,dp));
    }
}