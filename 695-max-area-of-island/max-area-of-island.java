class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int area=0;
        int maxArea=0;
        int[][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=1 && grid[i][j]==1){
                    area=dfs(i,j,m,n,grid,vis);
                }
                maxArea=Math.max(area,maxArea);
            }
        }
        return maxArea;
    }

    public int dfs(int row,int col,int m ,int n,int[][] grid,int[][] vis){
        vis[row][col]=1;
        int count=1;
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]!=1 && grid[nrow][ncol]==1){
                count+=dfs(nrow,ncol,m,n,grid,vis);
            }
        }
        return count;
    }
}