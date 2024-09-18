class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int shortestDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] distance=new int[m][n];
        int[][] reach=new int[m][n];
        int totalBuildings=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    totalBuildings++;
                    bfs(i,j,grid,distance,reach);
                }
            }
        }
        int result=Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && reach[i][j]==totalBuildings){
                    result=Math.min(result,distance[i][j]);
                }
            }
        }
        return (result==Integer.MAX_VALUE) ? -1 : result;
    }

    public void bfs(int row,int col,int[][] grid,int [][] distance,int[][] reach){
        int m=grid.length;
        int n=grid[0].length;

        boolean[][] visited=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(row,col));
        visited[row][col]=true;

        int dist=1;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int r=q.peek().row;
                int c=q.peek().col;
                q.poll();

                int[] dx={-1,0,1,0};
                int[] dy={0,1,0,-1};

                for(int k=0;k<4;k++){
                    int nrow=r+dx[k];
                    int ncol=c+dy[k];

                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !visited[nrow][ncol] && grid[nrow][ncol]==0){
                        distance[nrow][ncol]+=dist;
                        reach[nrow][ncol]++;
                        visited[nrow][ncol]=true;
                        q.offer(new Pair(nrow,ncol));
                    }
                }
            }
            dist++;
        }

    }
}