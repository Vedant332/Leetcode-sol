class Solution {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxi=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    maxi=Math.max(maxi,dfs(i,j,grid,m,n));
                }
            }
        }
        return maxi;
    }

    public int dfs(int row,int col,int[][] grid,int m,int n){
        int gold=grid[row][col];

        grid[row][col]=101;
        int maxGold=0;

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]!=101 && grid[nrow][ncol] != 0){
                maxGold=Math.max(maxGold,dfs(nrow,ncol,grid,m,n));
            }
        }
        grid[row][col]=gold;
        return maxGold+gold;
    }
}