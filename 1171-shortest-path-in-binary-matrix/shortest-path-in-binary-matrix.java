class tuple{
    int row;
    int col;
    int dist;
    public tuple(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<tuple> q=new LinkedList<>();
        int[][] visited=new int[m][n];

        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        q.offer(new tuple(0,0,1));
        visited[0][0]=1;

        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int d=q.peek().dist;
            q.poll();

            if(r==m-1 && c==n-1) return d;

            int dx[]={0,1,0,-1,1,-1,-1,1};
             int dy[]={1,0,-1,0,1,-1,1,-1};

            for(int i=0;i<8;i++){
                int nrow=r+dx[i];
                int ncol=c+dy[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && visited[nrow][ncol]!=1 ){
                    q.offer(new tuple(nrow,ncol,d+1));
                    visited[nrow][ncol]=1;
                }
            }
        }
        return -1;
    }
}