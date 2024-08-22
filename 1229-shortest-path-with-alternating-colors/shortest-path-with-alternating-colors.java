class Pair{
    int node;
    int edgeColor;
    public Pair(int node,int edgeColor){
        this.node=node;
        this.edgeColor=edgeColor;
    }
}

class Path{
    int node;
    int dist;
    int edgeColor;
    public Path(int node,int dist,int edgeColor){
        this.node=node;
        this.dist=dist;
        this.edgeColor=edgeColor;
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<Pair>> adj=create(n,redEdges,blueEdges);
        int[] ans=new int[n];
        Arrays.fill(ans, -1);
        ans[0]=0;
        Queue<Path> q=new LinkedList<>();
        boolean[][] visited=new boolean[n][2];
        q.offer(new Path(0,0,-1));

        while(!q.isEmpty()){
            int ele=q.peek().node;
            int d=q.peek().dist;
            int color=q.peek().edgeColor;
            q.poll();

            for(Pair it : adj.get(ele)){
                int adjNode=it.node;
                int adjCol=it.edgeColor;
                if(!visited[adjNode][adjCol] && adjCol!=color){
                    if (ans[adjNode] == -1) {  
                        ans[adjNode] = d + 1;
                    }
                    q.offer(new Path(adjNode,d+1,adjCol));
                    visited[adjNode][adjCol]=true;
                }
            }
        }
        return ans;
    }

    public  ArrayList<ArrayList<Pair>> create(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<redEdges.length;i++){
            int u=redEdges[i][0];
            int v=redEdges[i][1];
            adj.get(u).add(new Pair(v,1));
        }

        for(int i=0;i<blueEdges.length;i++){
            int u=blueEdges[i][0];
            int v=blueEdges[i][1];
            adj.get(u).add(new Pair(v,0));
        }
        return adj;
    }

}