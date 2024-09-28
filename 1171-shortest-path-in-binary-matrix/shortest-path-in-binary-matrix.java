class Pair{
    int r;
    int c;
    int d;
    public Pair(int r,int c,int d){
        this.r=r;
        this.c=c;
        this.d=d;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        if(grid[0][0]==1) return -1;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
         if(grid.length==1 && grid[0].length==1 && grid[n-1][n-1]==0) return 1;
        int[][] dist=new int[m][n];
        for(int[] row : dist){
            Arrays.fill(row,(int)1e9);
        }
        Queue<Pair> q= new LinkedList<>();
        dist[0][0]=1;
        q.offer(new Pair(0,0,1));

        while(!q.isEmpty()){
            int row=q.peek().r;
            int col=q.peek().c;
            int distance=q.peek().d;
            q.poll();

            if(row==m-1 && col==n-1 ) return distance;

             int dx[]={0,1,0,-1,1,-1,-1,1};
             int dy[]={1,0,-1,0,1,-1,1,-1};

             for(int i=0;i<8;i++){
                int nrow=row+dx[i];
                int ncol=col+dy[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && dist[nrow][ncol]>1+distance &&grid[nrow][ncol]==0){
                    dist[nrow][ncol]=1+distance;
                    q.offer(new Pair(nrow,ncol,1+distance));
                }
             }
        }
        return -1;
    }
}