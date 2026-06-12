class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected[0].length;
        int[] vis=new int[n];
        int count=0;

        for(int i=0;i<n;i++){
             if(vis[i]==0){
                dfs(i,vis,isConnected,n);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node ,int[] vis,int[][] isConnected, int n){
        vis[node]=1;

        for(int it=0;it<n;it++){
            if(isConnected[node][it] == 1 && vis[it]==0){
                dfs(it,vis,isConnected,n);
            }
        }
        return;
    }
}