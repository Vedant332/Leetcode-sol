class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i=obstacleGrid.length;
        int j=obstacleGrid[0].length;

        int[][] dp=new int[i][j];

        for(int m=0;m<i;m++){
            for(int n=0;n<j;n++){
                if(obstacleGrid[m][n]==1){
                    dp[m][n]=0;
                }
                else if(m==0 && n==0){
                    dp[m][n]=1;
                }else{
                    int up=0;
                    int left=0;
                    if(m>0) up=dp[m-1][n];
                    if(n>0) left=dp[m][n-1];
                  dp[m][n]=up+left;
                }
            }
        }

        return dp[i-1][j-1];
    }

    public int func(int m,int n,int[][] obstacleGrid){
        if(m>=0 && n>=0 && obstacleGrid[m][n]==1) return 0;
        if(m==0 && n==0) return 1;

        if(m<0 || n<0) return 0;

        int up=func(m-1,n,obstacleGrid);
        int left=func(m,n-1,obstacleGrid);

        return up+left;
    }
}