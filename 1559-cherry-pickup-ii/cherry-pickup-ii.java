class Solution {
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m][n][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return helper(grid,0,0,n-1,m,n,dp);
    }

    public int helper(int[][] grid,int i,int j1,int j2,int m,int n,int[][][] dp){
        if(j1<0  || j1>=n || j2<0 || j2>=n){
            return -10000;
        }
        if(i==m-1){
            if(j1==j2){
                return grid[i][j1];
            }else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi=-10000;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int value=0;
                if(j1==j2){
                    value=grid[i][j1]+helper(grid,i+1,j1+dj1,j2+dj2,m,n,dp);
                }else{
                    value=grid[i][j1]+grid[i][j2]+helper(grid,i+1,j1+dj1,j2+dj2,m,n,dp);
                }
                maxi=Math.max(maxi,value);
            }
        }
        return dp[i][j1][j2]=maxi;
    }
}