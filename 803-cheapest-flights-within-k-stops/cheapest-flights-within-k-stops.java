class Tuple{
    int stops;
    int node;
    int cost;
    public Tuple(int stops,int node,int cost){
        this.stops=stops;
        this.node=node;
        this.cost=cost;
    }
}
class Pair{
    int dest;
    int price;
    public Pair(int dest,int price){
        this.dest=dest;
        this.price=price;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
     List<List<Pair>> adj=new ArrayList<>();
     int[] dis=new int[n];
        Arrays.fill(dis,(int)1e9);
     
     for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
     }   

     for(int i=0;i<flights.length;i++){
        int u=flights[i][0];
        int v=flights[i][1];
        int p=flights[i][2];
        adj.get(u).add(new Pair(v,p));
     }
     dis[src]=0;
     Queue<Tuple> q=new LinkedList<>();
     q.offer(new Tuple(0,src,0));

     while(!q.isEmpty()){
        int ele=q.peek().node;
        int currStops=q.peek().stops;
        int minCost=q.peek().cost;
        q.poll();

        if(currStops>k) continue;

        for(Pair it : adj.get(ele)){
            int adjNode=it.dest;
            int edgeWeight=it.price;
            if(dis[adjNode]>edgeWeight+minCost){
                dis[adjNode]=edgeWeight+minCost;
                q.offer(new Tuple(currStops+1,adjNode,edgeWeight+minCost));
            }
        }
     }
     if(dis[dst]==(int)1e9) return -1;
     return dis[dst];
    }
}