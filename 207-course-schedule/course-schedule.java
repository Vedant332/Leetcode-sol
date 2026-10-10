class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(Integer it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int ele=q.poll();
            ans.add(ele);
            for(Integer it : adj.get(ele)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        return ans.size() == numCourses;
    }
}