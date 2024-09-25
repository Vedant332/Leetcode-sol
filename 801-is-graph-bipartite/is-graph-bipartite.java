class Pair{
    int node;
    int color;
    public Pair(int node,int color){
        this.node=node;
        this.color=color;
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        int[] color=new int[m];
        Arrays.fill(color,-1);
        
        for(int i=0;i<m;i++){
            if(color[i]==-1){
                if(!bfs(graph,i,color,0)) return false;
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph,int node,int[] color,int colour){
        Queue<Pair> q=new LinkedList<>();
        color[node]=colour;
        q.offer(new Pair(node,colour));

        while(!q.isEmpty()){
            int ele=q.peek().node;
            int col=q.peek().color;
            q.poll();

            for(int it : graph[ele]){
                if(color[it]==-1){
                    color[it]=1-col;
                    q.offer(new Pair(it,1-col));
                }else{
                    if(color[it]==col){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph,int node,int[] color,int colour){
        color[node]=colour;

        for(int it : graph[node]){
            if(color[it]==-1){
                if(!dfs(graph,it,color,1-colour)) return false;
            }else{
                if(color[it]==colour){
                    return false;
                }
            }
        }
        return true;
    }
}