class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] visited=new int[m][n];
        for(int[] row : visited){
            Arrays.fill(row,0);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    dfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int row,int col,char[][] grid,int[][] visited){
        visited[row][col]=1;

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
                dfs(nrow,ncol,grid,visited);
            }
        }
    }
}