class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        Queue<Pair> q=new LinkedList<>();
        int[][] dist=new int[9][9];
        q.offer(new Pair(source[0],source[1]));
        for(int[] row : dist){
            Arrays.fill(row,(int)1e9);
        }
        dist[source[0]][source[1]]=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            q.poll();

            if(r==target[0] && c==target[1]) return dist[r][c];

            int[] dx={1,1,-1,-1};
            int[] dy={-1,1,1,-1};
            for(int i=0;i<4;i++){
                int nrow=r+dx[i];
                int ncol=c+dy[i];
                while(nrow>= 1 && nrow<9 && ncol>=1 && ncol<9){
                    if(dist[nrow][ncol]>1+dist[r][c]){
                        dist[nrow][ncol]=1+dist[r][c];
                    }else{
                        nrow+=dx[i];
                        ncol+=dy[i];
                        continue;
                    }
                    q.offer(new Pair(nrow,ncol));
                    nrow+=dx[i];
                    ncol+=dy[i];
                }
            }
        }
        return -1;
    }
}