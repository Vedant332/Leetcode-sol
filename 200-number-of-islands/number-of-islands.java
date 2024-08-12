class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int[][] vis=new int [grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j]!=1 && grid[i][j]=='1'){
                    dfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row,int col, int[][] vis,char[][] grid){
        vis[row][col]=1;
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && vis[nrow][ncol]!=1 && grid[nrow][ncol]=='1'){
                dfs(nrow,ncol,vis,grid);
            }
        }
    }
}