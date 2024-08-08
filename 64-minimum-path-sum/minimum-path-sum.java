class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];

        

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[0][0]=grid[0][0];
                }else{
                    int up = grid[i][j];
                    if(i>0) up+=dp[i - 1][j];
                    else up+=9999;

                    int left = grid[i][j];
                    if(j>0) left+=dp[i][j - 1];
                    else left+=9999;
                    dp[i][j] =   Math.min(up, left);
                }
            }
        }
        
        return dp[m-1][n-1];
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