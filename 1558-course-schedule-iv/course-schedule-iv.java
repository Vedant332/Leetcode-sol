class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            boolean[] visited=new boolean[numCourses];
            boolean res=dfs(queries[i][0],queries[i][1],adj,visited);
            ans.add(res);
        }
        return ans;
    }

    public boolean dfs(int start,int end,List<List<Integer>> adj,boolean[] visited){
        visited[start]=true;
        if(start==end) return true;

        for(int it: adj.get(start)){
            if(visited[it]!=true){
                if(dfs(it,end,adj,visited)) return true;
            }
        }
        return false;
    }
}