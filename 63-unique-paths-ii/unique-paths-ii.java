class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0 && obstacleGrid[i][j]!=1) dp[i][j]=1;
                else{
                    int up=0;
                    int down=0;
                    if(i>0 && obstacleGrid[i][j]!=1) up=dp[i-1][j];
                     if(j>0 && obstacleGrid[i][j]!=1)down=dp[i][j-1];

                     dp[i][j]=up+down;
                }
            }
        }

        return dp[m-1][n-1];
    }

    public int func(int i,int j,int[][] arr,int[][] dp){
        if(i<0 || j<0 || arr[i][j]==1) return 0;
        if(i==0 && j==0) return 1;

        if(dp[i][j]!=-1) return dp[i][j];
        int up=func(i-1,j,arr,dp);
        int down=func(i,j-1,arr,dp);

        return dp[i][j]=up+down;
    }
}