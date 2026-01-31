class Pair{
    int row;
    int col;
    int time;
    public Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        int cntFresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    vis[i][j]=1;
                    q.offer(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }

        int cnt=0;
        int minTm=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            q.poll();

            minTm=Math.max(minTm,t);

            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=r+dx[i];
                int ncol=c+dy[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1 && vis[nrow][ncol]!=1){
                    q.offer(new Pair(nrow,ncol,t+1));
                    cnt++;
                    vis[nrow][ncol]=1;
                }
            }
        }

        if(cnt!=cntFresh) return -1;
        else return (minTm==Integer.MIN_VALUE)?0:minTm ;
    }
}