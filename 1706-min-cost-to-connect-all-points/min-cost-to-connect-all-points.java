class Point{
    int distance;
    int x;
    int y;
    public Point(int distance,int x,int y){
        this.distance=distance;
        this.x=x;
        this.y=y;
    }
}
class DisjointSet{
    ArrayList<Integer> rank =new ArrayList<>();
    ArrayList<Integer> parent=new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }

        public int findPar(int u){
            if(parent.get(u)==u) return u;

            int ulp=findPar(parent.get(u));
            parent.set(u,ulp);
            return parent.get(u);
        }

        public void unionByRank(int u,int v){
            int ulp_u=findPar(u);
            int ulp_v=findPar(v);
            if(ulp_u==ulp_v) return;
            if(rank.get(ulp_u)<rank.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
            }else if(rank.get(ulp_v)<rank.get(ulp_u)){
                parent.set(ulp_v,ulp_u);
            }else{
                parent.set(ulp_v,ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int m=points.length;
        PriorityQueue<Point> pq=new PriorityQueue<>((l1, l2) -> l1.distance - l2.distance);
        DisjointSet ds= new DisjointSet(m);
        int td=0;

        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                int dist= Math.abs(points[i][0]-points[j][0])+ Math.abs(points[i][1]-points[j][1]);
                pq.offer(new Point(dist,i,j));
            }
        }

        while(!pq.isEmpty()){
            Point curr=pq.poll();

            if(ds.findPar(curr.x)!=ds.findPar(curr.y)){
                ds.unionByRank(curr.x,curr.y);
                td+=curr.distance;
            } 
        }
        return td;
    }
}