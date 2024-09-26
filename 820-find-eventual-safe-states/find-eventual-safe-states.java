class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int m=graph.length;
       int[] vis=new int[m];
       int[] pathVis=new int[m];
       int[] check=new int[m];
       List<Integer> ls=new ArrayList<>();

       for(int i=0;i<m;i++){
        if(vis[i]==0){
            dfs(graph,i,vis,pathVis,check);
        }
       }

       for(int i=0;i<m;i++){
        if(check[i]==1){
            ls.add(i);
        }
       }
       return ls;
    }

    public boolean dfs(int[][] graph,int node,int[] vis,int[] pathVis,int[] check){
        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;

        for(int it : graph[node]){
            if(vis[it]==0){
                if(dfs(graph,it,vis,pathVis,check)) return true;
            }else{
                if(pathVis[it]==1) return true;
            }
        }
        check[node]=1;
        pathVis[node]=0;
        return false;
    }
}