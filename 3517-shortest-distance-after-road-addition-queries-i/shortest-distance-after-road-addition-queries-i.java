class Pair{
    int node;
    int dist;
    public Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            adj.get(i).add(i+1);
        }
        int[] ans=new int[queries.length];

        for(int i=0;i<queries.length;i++){
            adj.get(queries[i][0]).add(queries[i][1]);
            ans[i]=bfs(adj,new int[n],n-1,0);
        }
        return ans;
    }

    public int bfs(List<List<Integer>> adj,int[] visited,int end,int src){
        Queue<Pair> q=new LinkedList<>();
        visited[src]=1;
        q.offer(new Pair(src,0));

        while(!q.isEmpty()){
            Pair it=q.poll();
            int ele=it.node;
            int d=it.dist;

            if(ele==end) return d;

            for(int i : adj.get(ele)){
                if(visited[i]==0){
                    q.offer(new Pair(i,d+1));
                    visited[i]=1;
                }
            }
        }
        return -1;
    }
}