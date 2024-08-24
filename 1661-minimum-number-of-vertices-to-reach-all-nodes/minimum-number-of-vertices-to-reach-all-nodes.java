class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.size();i++){
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);
            adj.get(u).add(v);
            indegree[v]++;
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                ans.add(i);
            }
        }
        return ans; 
    }
}