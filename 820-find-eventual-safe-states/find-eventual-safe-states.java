class Solution {
    public boolean dfs(int node,int[] vis,int[] pathvis,int[] check,int[][] graph) {
       vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        for(Integer it : graph[node]){
            if(vis[it]!=1){
                if(dfs(it,vis,pathvis,check,graph)==true) return true;
            }else if(pathvis[it]==1){
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        int[] vis=new int[n];
        int[] pathvis=new int[n];
        int[] check=new int[n];

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,vis,pathvis,check,graph);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
}