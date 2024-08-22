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
    public int maxDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }

        int maxDistance=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int row=q.peek().r;
            int col=q.peek().c;
            int dist=q.peek().d;
            q.poll();

            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};

            for(int i=0;i<4;i++){
                int nrow=row+dx[i];
                int ncol=col+dy[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && vis[nrow][ncol]==false){
                    q.offer(new Pair(nrow,ncol,dist+1));
                    maxDistance=Math.max(maxDistance,dist+1);
                    vis[nrow][ncol]=true;
                }
            }
        }
        if(maxDistance==Integer.MIN_VALUE) return -1;
        else return maxDistance;
    }
}