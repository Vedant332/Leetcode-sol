class Solution {
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        int n=graph[0].length;
        int[] color=new int[m];
        Arrays.fill(color,-1);

        for(int i=0;i<m;i++){
            if(color[i]==-1){
                if(dfs(i,graph,color,0)==false) return false;
            }
        }
        return true;
    }

    public boolean dfs(int node,int[][] graph,int[] color,int prevNode){
        color[node]=prevNode;

        for(int it : graph[node]){
            if(color[it]==-1){
                if(dfs(it,graph,color,1-prevNode)==false) return false;
            }else if(color[it]==prevNode){
                return false;
            }
        }
        return true;
    }
}