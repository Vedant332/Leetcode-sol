class Solution {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxi=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    maxi=Math.max(maxi,dfs(i,j,m,n,grid,new int[m][n]));
                }
            }
        }
        return maxi;
    }

    public int dfs(int row,int col,int m,int n,int[][] grid,int[][] vis){
        vis[row][col]=1;

        int gold=0;

         int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]!=0 && vis[nrow][ncol]==0){
                gold=Math.max(gold,dfs(nrow,ncol,m,n,grid,vis));
            }
        }
        vis[row][col] = 0;
        return grid[row][col]+gold;
    }
}