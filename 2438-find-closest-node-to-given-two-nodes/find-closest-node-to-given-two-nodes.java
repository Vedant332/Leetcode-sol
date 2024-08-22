class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int[] dist1=new int[n];
        int[] dist2=new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);

        bfs(edges,node1,dist1);
        bfs(edges,node2,dist2);

        int minNode=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(dist1[i]!=Integer.MAX_VALUE && dist2[i]!=Integer.MAX_VALUE ){
                int maxi=Math.max(dist1[i],dist2[i]);
                if(maxi<min){
                    min=maxi;
                    minNode=i;
                }
            }
        }
        return minNode;
    }

    public void bfs(int[] edges,int node,int[] dist){
        Queue<Integer> q=new LinkedList<>();
        q.offer(node);
        dist[node]=0;

        while(!q.isEmpty()){
            int ele=q.peek();
            q.poll();
            int adjEle=edges[ele];
            if(adjEle!=-1 && dist[adjEle]==Integer.MAX_VALUE){
                dist[adjEle]=1+dist[ele];
                q.offer(adjEle);
            }
        }
    }
}