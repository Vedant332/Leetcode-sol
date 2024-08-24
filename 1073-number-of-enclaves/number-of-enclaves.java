class Solution {
    public int numEnclaves(int[][] grid) {
         int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        int edgeCount[]=new int[1];
        for(int i=0;i<m;i++){
            if(visited[i][0]!=1 && grid[i][0]==1){
                dfs(i,0,grid,visited,edgeCount);
            }
            if(visited[i][n-1]!=1 && grid[i][n-1]==1){
                dfs(i,n-1,grid,visited,edgeCount);
            }
        }

        for(int i=0;i<n;i++){
            if(visited[0][i]!=1 && grid[0][i]==1){
                dfs(0,i,grid,visited,edgeCount);
            }
            if(visited[m-1][i]!=1 && grid[m-1][i]==1){
                dfs(m-1,i,grid,visited,edgeCount);
            }
        }
        int[] count=new int[1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]!=1 && grid[i][j]==1){
                    dfs(i,j,grid,visited,count);
                }
            }
        }
        return count[0];
    }

    public void dfs(int row,int col,int[][] grid,int[][] visited,int[] count){
        int m=grid.length;
        int n=grid[0].length;
        visited[row][col]=1;
        count[0]=count[0]+1;

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]!=1 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid,visited,count);
            }
        }
    }
}