class Solution {
    public int maximumDetonation(int[][] bombs) {
         int n = bombs.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            long r1sq = (long) bombs[i][2] * bombs[i][2];
            graph.put(i, new LinkedList<>());  

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int x2 = bombs[j][0];
                    int y2 = bombs[j][1];
                    long distanceSq = (long) (x2 - x1) * (x2 - x1) + (long) (y2 - y1) * (y2 - y1);

                    if (r1sq >= distanceSq) {
                        graph.get(i).add(j);  
                    }
                }
            }
        }
        int maxi=0;
        for(int i=0;i<n;i++){
            Set<Integer> visited=new HashSet<>();
            dfs(i,visited,graph);
            maxi=Math.max(maxi,visited.size());
        }
        return maxi;
    }

    public void dfs(int node,Set<Integer> visited,Map<Integer, List<Integer>> graph){
        visited.add(node);

        for(Integer it : graph.get(node)){
            if(!visited.contains(it)){
                dfs(it,visited,graph);
            }
        }
    }
}