class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(grid,m-1,n-1,dp);
    }
    public int helper(int[][] arr,int i,int j,int[][] dp){
        if (i < 0 || j < 0) return Integer.MAX_VALUE; 

        if (i == 0 && j == 0) return arr[i][j];

        if (dp[i][j] != -1) return dp[i][j];
        int up = helper(arr, i - 1, j, dp);
        int left = helper(arr, i, j - 1, dp);
        dp[i][j] = arr[i][j] + Math.min(up, left);

        return dp[i][j];
    }
}