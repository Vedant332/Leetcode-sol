class Solution {
    int timer=1;
    public void dfs(int node ,int par,int[] vis,int[] tin,int[] low,List<List<Integer>> adj,List<List<Integer>> bridges){
        vis[node]=1;
        tin[node]=timer;
        low[node]=timer;
        timer++;

        for(int it : adj.get(node)){
            if(it==par) continue;
            if(vis[it]==0){
                dfs(it,node,vis,tin,low,adj,bridges);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    bridges.add(Arrays.asList(it,node));
                }
            }else{
                low[node]=Math.min(low[node],low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<connections.size();i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        int[] vis=new int[n];
        int[] tin=new int[n];
        int[] low=new int[n];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,vis,tin,low,adj,bridges);
        return bridges;
    }
}