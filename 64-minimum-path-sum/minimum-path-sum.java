class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int m=0;m<grid.length;m++){
            for(int n=0;n<grid[0].length;n++){
                if(m==0 && n==0) dp[m][n]=grid[0][0];
                else{
                    int up=0;
                    int left=0;
                   if(m>0) up=grid[m][n]+dp[m-1][n];
                   else up=(int) 1e9;
                    if(n>0) left=grid[m][n]+dp[m][n-1];
                    else left=(int) 1e9;
                     dp[m][n]=Math.min(up,left);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public int helper(int[][] grid,int m,int n,int[][] dp){
        if(m==0 && n==0){
            return grid[m][n];
        }

        if(m<0 || n<0) return (int) 1e9;

        if(dp[m][n]!=-1) return dp[m][n];

        int up=grid[m][n]+helper(grid,m-1,n,dp);
        int left=grid[m][n]+helper(grid,m,n-1,dp);

        return dp[m][n]=Math.min(up,left);

    }
}