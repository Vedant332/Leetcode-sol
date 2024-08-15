class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        Queue<Integer> q =new LinkedList<>();
        int[] indegree=new int[graph.length];

         for(int i=0;i<graph.length;i++){
            for(int it : graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
         }
         for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) {
                q.add(i);
            }
         }
         List<Integer> ans=new ArrayList<>();
         while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            ans.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }

         }
         Collections.sort(ans);
         return ans;
    }
}