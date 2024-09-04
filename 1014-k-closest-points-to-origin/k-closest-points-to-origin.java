class Point{
    int x;
    int y;
    int dist;
    public Point(int x,int y,int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
        for(int i=0;i<points.length;i++){
            int xcor=points[i][0];
            int ycor=points[i][1];
            int distance=xcor*xcor+ycor*ycor;
            pq.add(new Point(xcor,ycor,distance));
        }

        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){ 
            ans[i][0] = pq.peek().x;
            ans[i][1] = pq.peek().y;
            pq.poll();
        }
        return ans;
    }
}