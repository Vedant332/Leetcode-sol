class Pair{
    int dest;
    int weight;
    public Pair(int dest,int weight){
        this.dest=dest;
        this.weight=weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.weight-y.weight);
        int[] dist=new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k]=0;
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            int node=pq.peek().dest;
            int wt=pq.peek().weight;
            pq.remove();

            for(Pair it : adj.get(node)){
                if(it.weight+wt<dist[it.dest]){
                    dist[it.dest]=it.weight+wt;
                    pq.add(new Pair(it.dest,it.weight+wt));
                }
            }
        }
        int ans=0;
        for(int i=1;i<dist.length;i++){
            if(dist[i]==(int)1e9) return -1;
            else ans =Math.max(dist[i],ans);
        }
        return ans;
    }
}