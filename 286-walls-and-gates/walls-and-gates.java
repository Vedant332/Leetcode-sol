class Pair{
    int row;
    int col;
    int dis;
    public Pair(int row,int col,int dis){
        this.row=row;
        this.col=col;
        this.dis=dis;
    }
}
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<Pair> q=new LinkedList<>();
        int m=rooms.length;
        int n=rooms[0].length;

        int[][] vis=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=1 && rooms[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }

        while(!q.isEmpty()){
            Pair ele=q.poll();
            int r=ele.row;
            int c=ele.col;
            int d=ele.dis;
            
            rooms[r][c]=d;

             int[] dx={0,-1,0,1};
             int[] dy={-1,0,1,0};
             for(int i=0;i<4;i++){
                int nrow=dx[i]+r;
                int ncol=dy[i]+c;
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && rooms[nrow][ncol]!=-1 ){
                    q.offer(new Pair(nrow,ncol,d+1));
                    vis[nrow][ncol]=1;
                }
             }
        }
    }
}