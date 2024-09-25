class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        HashSet<List<String>> hs=new HashSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=1 && grid[i][j]==1){
                    List<String> ls=new ArrayList<>();
                    dfs(i,j,grid,vis,ls,i,j,m,n);
                    hs.add(ls);
                }
            }
        }
        return hs.size();
    }
    public String toString(int row,int col){
        return Integer.toString(row) + ""+Integer.toString(col);
    }
    public void dfs(int row,int col,int[][] grid,int[][] vis,List<String> ls,int row0,int col0,int m,int n){
        vis[row][col]=1;
        ls.add(toString(row0-row,col0-col));
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]!=1 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid,vis,ls,row0,col0,m,n);
            }
        }
    }
}