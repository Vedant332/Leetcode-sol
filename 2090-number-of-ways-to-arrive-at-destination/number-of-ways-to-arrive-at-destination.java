class Pair{
    int node;
    long wt;
    public Pair(int node,long wt){
        this.node=node;
        this.wt=wt;
    }
}

class Solution {
    static int mod = (int)(Math.pow(10, 9)+7);
    public int countPaths(int n, int[][] roads) {
        int m=roads.length;
        List<List<Pair>> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        long[] dist=new long[n];
        int[] ways=new int[n];
         Arrays.fill(dist,Long.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.wt, y.wt));
        pq.add(new Pair(0,0));
        dist[0]=0;
        ways[0]=1;

        while(!pq.isEmpty()){
            int ele=pq.peek().node;
            long w=pq.peek().wt;
            pq.remove();

            for(Pair it : adj.get(ele)){
                int adjNode=it.node;
                long edgeWt=it.wt;
                if(dist[adjNode]>edgeWt+w){
                    dist[adjNode]=edgeWt+w;
                    ways[adjNode]=ways[ele];
                    pq.add(new Pair(adjNode,edgeWt+w));
                }else if (dist[adjNode] == edgeWt + w) {
                    ways[adjNode] = (ways[adjNode] + ways[ele]) % mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}