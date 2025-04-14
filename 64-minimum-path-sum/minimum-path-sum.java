class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp= new int[m][n];
        

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j]=grid[i][j];
                else{
                    int up=0;
                    int left=0;
                    if(i>0) up=grid[i][j]+dp[i-1][j];
                    else up=(int) 1e9;
                    if(j>0) left=grid[i][j]+dp[i][j-1];
                    else left=(int) 1e9;

                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int func(int i,int j, int[][] grid,int[][] dp){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return (int) 1e9;

        if(dp[i][j]!=-1) return dp[i][j];
        int up=grid[i][j]+func(i-1,j,grid,dp);
        int left=grid[i][j]+func(i,j-1,grid,dp);

        return dp[i][j]=Math.min(up,left);
    }
}