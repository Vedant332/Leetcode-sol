class tuple{
    int r;
    int c;
    int d;
    public tuple(int r,int c,int d){
        this.r=r;
        this.c=c;
        this.d=d;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] dist=new int[m][n];
        for(int[] row : dist){
            Arrays.fill(row,(int)1e9);
        }
        dist[0][0]=0;
        PriorityQueue<tuple> pq=new PriorityQueue<>((x,y)->x.d-y.d);
        pq.add(new tuple(0,0,0));

        while(!pq.isEmpty()){
            int row=pq.peek().r;
            int col=pq.peek().c;
            int diff=pq.peek().d;
            pq.remove();

            if(row==m-1 && col==n-1) return diff;

            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};

            for(int i=0;i<4;i++){
                int nrow=row+dx[i];
                int ncol=col+dy[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n){
                    int maxEffort=Math.max(Math.abs(heights[nrow][ncol]-heights[row][col]),diff);
                    if(maxEffort<dist[nrow][ncol]){
                        dist[nrow][ncol]=maxEffort;
                        pq.add(new tuple(nrow,ncol,dist[nrow][ncol]));
                    }
                }
            }
        }
        return 0;
    }
}