class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(grid,grid.length-1,grid[0].length-1,dp);
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