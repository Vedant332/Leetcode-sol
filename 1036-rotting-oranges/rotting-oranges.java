class tuple{
    int r;
    int c;
    int t;
    public tuple(int r ,int c ,int t){
        this.r=r;
        this.c=c;
        this.t=t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        Queue<tuple> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new tuple(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int tm=0;
        int cnt=0;
        while(!q.isEmpty()){
            int r1=q.peek().r;
            int c1=q.peek().c;
            int t=q.peek().t;
            tm=Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=r1+dx[i];
                int ncol=c1+dy[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.add(new tuple(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=fresh) return -1;

        return tm;
    }
}