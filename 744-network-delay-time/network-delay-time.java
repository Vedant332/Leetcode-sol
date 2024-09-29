class Pair{
    int node;
    int wt;
    public Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int m=times.length;
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.wt-y.wt);

        int[] dist=new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k]=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            int ele=pq.peek().node;
            int tm=pq.peek().wt;
            pq.remove();

            for(Pair it : adj.get(ele)){
                int adjNode=it.node;
                int edgeWt=it.wt;
                if(dist[adjNode]>edgeWt+tm){
                    dist[adjNode]=edgeWt+tm;
                    pq.add(new Pair(adjNode,edgeWt+tm));
                }
            }
        }
        int ans=dist[1];
        for(int i=1;i<=n;i++){
            if(dist[i]==(int)1e9) return -1;
            else ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}