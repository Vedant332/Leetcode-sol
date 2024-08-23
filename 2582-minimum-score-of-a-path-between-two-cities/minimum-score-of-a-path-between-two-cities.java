class Pair{
    int node;
    int dist;
    public Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++){
            int[] arr=roads[i];
            int a=arr[0];
            int b=arr[1];
            int c=arr[2];
            adj.get(a).add(new Pair(b,c));
            adj.get(b).add(new Pair(a,c));
        }
        int[] visited=new int[n+1];

        int minScore=Integer.MAX_VALUE;
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        visited[1]=1;

        while(!q.isEmpty()){
            int ele=q.poll();

            for(Pair it : adj.get(ele)){
                minScore=Math.min(minScore,it.dist);
                if(visited[it.node]!=1){
                    q.offer(it.node);
                    visited[it.node]=1;
                }
            }
        }
        //dfs(1,-1,n,adj,minScore);

        return minScore;
    }

    public void dfs(int src,int prev,int dest, List<List<Pair>> adj,int[] minScore){
        if(src==dest) return;

        for(Pair it : adj.get(src)){
            int ele=it.node;
            int len=it.dist;
            minScore[0]=Math.min(len,minScore[0]);
            if(ele!=prev){
                dfs(ele,src,dest,adj,minScore);
            }
        }
    }
}