class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    maxArea=Math.max(maxArea,dfs(i,j,grid,vis,n,m));
                }
            }
        }
        return maxArea;
    }
    public int dfs(int row,int col,int[][] grid,int[][] vis,int n,int m){
        vis[row][col]=1;

        int count=0;

        int[] dx={0,-1,0,1};
        int[] dy={-1,0,1,0};
        for(int i=0;i<4;i++){
            int nrow=dx[i]+row;
            int ncol=dy[i]+col;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                count+=dfs(nrow,ncol,grid,vis,n,m);
            }
        }
        return 1+count;
    }
}