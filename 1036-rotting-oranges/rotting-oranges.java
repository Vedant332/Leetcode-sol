class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        Queue<Pair> q =new LinkedList<>();
        int cntFresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    vis[i][j]=1;
                    q.offer(new Pair(i,j));
                }else if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }

        int cnt=0;
        int tm=0;

        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                Pair ele=q.poll();
                int r=ele.row;
                int c=ele.col;
                 int[] dx={0,-1,0,1};
                int[] dy={-1,0,1,0};
                for(int i=0;i<4;i++){
                    int nrow=dx[i]+r;
                    int ncol=dy[i]+c;
                            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1 ){
                                q.offer(new Pair(nrow,ncol));
                                cnt++;
                                vis[nrow][ncol]=1;
                            }
                    }
                }
                if(!q.isEmpty()) tm++;
        }
        if(cnt!=cntFresh) return -1;
        return tm;
    }
}