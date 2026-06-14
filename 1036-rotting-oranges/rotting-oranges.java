class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis =new int[n][m];
        int freshCount=0;

        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int rotCount=0;
        int tm=0;
        while(!q.isEmpty()){
            int size=q.size();
            boolean rotted = false;

            for(int i=0;i<size;i++){
                int r=q.peek().row;
                 int c=q.peek().col;  
                 q.poll();

                    int[] dx={0,-1,0,1};
                    int[] dy={-1,0,1,0};
                    for(int j=0;j<4;j++){
                        int nrow=dx[j]+r;
                        int ncol=dy[j]+c;
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                            vis[nrow][ncol]=1;
                            q.offer(new Pair(nrow,ncol));
                            rotCount++;
                            rotted = true;
                        }
                  }
            }
            if(rotted) tm++;
        }
        if(rotCount!=freshCount) return -1;
        return tm;
    }
}