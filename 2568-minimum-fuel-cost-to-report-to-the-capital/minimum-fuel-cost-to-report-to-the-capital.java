class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> adj=new ArrayList<>();
        long[] fuel=new long[1];

        for(int i=0;i<roads.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0,-1,seats,adj,fuel);
        return fuel[0];
    }

    public long dfs(int node,int prevNode,int seats, List<List<Integer>> adj,long[] fuel){
        long people=1;

        for(int it : adj.get(node)){
            if(it!=prevNode){
                people+=dfs(it,node,seats,adj,fuel);
            }
        } 
        if(node!=0){
            fuel[0]+=(long) (Math.ceil((double) people/seats));
        }
        return people;
    }
}