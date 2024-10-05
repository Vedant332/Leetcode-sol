class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
       if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp=new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(obstacleGrid,m-1,n-1,dp);
    }

    public int func(int[][] obstacleGrid,int i,int j,int[][] dp){
        if(i<0 || j<0 ) return 0;
        if(i==0 && j==0) return 1;
        if(obstacleGrid[i][j]==1) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int up=func(obstacleGrid,i-1,j,dp);
        int left=func(obstacleGrid,i,j-1,dp);

        return dp[i][j]=up+left;
    }
}