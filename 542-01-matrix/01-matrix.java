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
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] vis=new int[m][n];
        int[][] dist=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int d=q.peek().dist;
            q.poll();

            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};

            for(int i=0;i<4;i++){
                int nrow=r+dx[i];
                int ncol=c+dy[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && mat[nrow][ncol]==1){
                    dist[nrow][ncol]=1+d;
                    vis[nrow][ncol]=1;
                    q.offer(new Pair(nrow,ncol,d+1));
                }
            }
        }
        return dist;
    }
}