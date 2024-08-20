class tuple{
    int distance;
    int row;
    int col;
    tuple(int distance,int row,int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int n=grid.length;
        int m=grid[0].length;
         if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        if(grid.length==1 && grid[0].length==1 && grid[n-1][m-1]==0) return 1;
        
        Queue<tuple> q=new LinkedList<>();
        int[][] dist=new int[n][m];
        for(int[] row : dist){
            Arrays.fill(row, (int)(1e9));
        }
        dist[0][0]=1;
        q.add(new tuple(dist[0][0],0,0));
        while(!q.isEmpty()){
            int distance=q.peek().distance;
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();

            int dx[]={0,1,0,-1,1,-1,-1,1};
        int dy[]={1,0,-1,0,1,-1,1,-1};
            for(int i=0;i<8;i++){
                    int nrow=row+dx[i];
                    int ncol=col+dy[i];

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0 
                    && dist[nrow][ncol]>1+distance){
                        dist[nrow][ncol]=1+distance;
                        if(nrow==n-1 && ncol==m-1) return distance+1;
                        q.add(new tuple(1+distance,nrow,ncol));
                    }
                }
            }
             return -1;
        }
    }