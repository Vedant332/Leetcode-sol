class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1) return 0;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<manager.length;i++){
            int mgr = manager[i];
            if(!map.containsKey(mgr)){
                map.put(mgr, new ArrayList<>());
            }
            map.get(mgr).add(i);
        }
        return dfs(headID,map,informTime);
    }

    public int dfs(int headID,HashMap<Integer,List<Integer>> map,int[] informTime){
        if (informTime[headID] == 0) return 0;
        int time=0;
        for(int directId : map.get(headID)){
            time=Math.max(time,dfs(directId,map,informTime));
        }
        return informTime[headID]+time;
    }
}