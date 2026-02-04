class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
     List<String> ans =new ArrayList<>();
        HashMap<String,List<String>> adj=new HashMap<>();
        for(List<String> it: tickets){
            String from=it.get(0);
            String to=it.get(1);

            adj.putIfAbsent(from,new ArrayList<>());
            adj.get(from).add(to);
        }

        for(String it : adj.keySet()){
            Collections.sort(adj.get(it));
        }
        dfs("JFK",adj,ans);
        return ans;
    }

    public void dfs(String s,HashMap<String,List<String>> adj, List<String> ans ){
          List<String> neighbors = adj.get(s);
        while (neighbors != null && !neighbors.isEmpty()) {
            String next = neighbors.remove(0); 
            dfs(next, adj, ans);
        }
        ans.add(0, s); 
    }
}