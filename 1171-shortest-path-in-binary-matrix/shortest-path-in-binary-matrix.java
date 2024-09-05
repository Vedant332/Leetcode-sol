class Pair{
    int row;
    int col;
    int dist;
    public Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
          if(grid[0][0]==1) return -1;
        int n=grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
         if(grid.length==1 && grid[0].length==1 && grid[n-1][n-1]==0) return 1;
        Queue<Pair> q=new LinkedList<>();
        int[][] distance=new int[n][n];
        for(int[] row : distance){
            Arrays.fill(row,(int) (1e9));
        }
        distance[0][0]=1;

        
        q.offer(new Pair(0,0,distance[0][0]));

        int dx[]={0,1,0,-1,1,-1,-1,1};
        int dy[]={1,0,-1,0,1,-1,1,-1};

        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int d=q.peek().dist;
            q.poll();

            for(int i=0;i<8;i++){
                int nrow=r+dx[i];
                int ncol=c+dy[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && distance[nrow][ncol]>1+d && grid[nrow][ncol]==0){
                    distance[nrow][ncol]=1+d;
                    if(nrow==n-1 && ncol==n-1){
                        return 1+d;
                    }
                    q.offer(new Pair(nrow,ncol,distance[nrow][ncol]));
                }
            }
        }
        return -1;
    }
}