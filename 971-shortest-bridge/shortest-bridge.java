class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {

    public void dfs(int r,int c,int m,int n,int[][] grid,int[][] vis,Queue<Pair> q){
        vis[r][c]=1;
        q.offer(new Pair(r,c));

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for(int i=0;i<4;i++){
            int nrow=r+dx[i];
            int ncol=c+dy[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1 && vis[nrow][ncol]!=1){
                dfs(nrow,ncol,m,n,grid,vis,q);
            }
        }
    }
    public int shortestBridge(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        Queue<Pair> q=new LinkedList<>();

        boolean flag=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(i,j,m,n,grid,vis,q);
                    flag=true;
                    break;
                }
            }
            if(flag==true) break;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int steps=0;

        while(!q.isEmpty()){

            int size=q.size();
            for(int j=0;j<size;j++){
                int r=q.peek().row;
                int c=q.peek().col;
                q.poll();

            for(int i=0;i<4;i++){
                int nrow=r+dx[i];
                int ncol=c+dy[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0){
                    if(grid[nrow][ncol]==1){
                        return steps;
                    }
                    q.offer(new Pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                }
            }
            }
            steps++;
        }
        return -1;
    }
} 