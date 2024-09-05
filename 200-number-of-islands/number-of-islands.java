class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] visited=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    dfs(i,j,grid,visited,m,n);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row,int col,char[][] grid,int[][] visited,int m,int n){
        visited[row][col]=1;

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]!=1 && grid[nrow][ncol]=='1'){
                dfs(nrow,ncol,grid,visited,m,n);
            }
        }
    }
}