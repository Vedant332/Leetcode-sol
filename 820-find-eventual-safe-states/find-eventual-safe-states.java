class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int m=graph.length;
       List<List<Integer>> adj=new ArrayList<>();
       List<Integer> ls=new ArrayList<>();
       for(int i=0;i<m;i++){
        adj.add(new ArrayList<>());
       }
       Queue<Integer> q =new LinkedList<>();
       int[] indegree=new int[m];

       for(int i=0;i<m;i++){
        for(int it:graph[i]){
            adj.get(it).add(i);
            indegree[i]++;
        }
       }

       for(int i=0;i<m;i++){
        if(indegree[i]==0){
            q.offer(i);
        }
       }
       while(!q.isEmpty()){
        int node=q.poll();
        ls.add(node);

        for(int it:adj.get(node)){
            indegree[it]--;
            if(indegree[it]==0){
                q.offer(it);
            }
        }
       }
       Collections.sort(ls);
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