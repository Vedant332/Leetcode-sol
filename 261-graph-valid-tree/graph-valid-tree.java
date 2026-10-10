class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] vis=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                if(dfs(i,adj,vis,-1)) return false;
                count++;
            }
        }
        if(count>1) return false;
        else return true;
    }

    public boolean dfs(int node,List<List<Integer>> adj,int[] vis,int par){
        vis[node]=1;

        for(Integer it : adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,adj,vis,node)) return true;
            }else{
                if(it != par) return true;
            }
        }
        return false;
    }
}