class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree=new int[n];

        for(int i=0;i<edges.length;i++){
            indegree[edges[i][1]]++;
        }
        int ans=0;
        boolean flag=false;

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0 && flag==false){
                ans=i;
                flag=true;
            }else if(indegree[i]==0 && flag==true){
                flag=false;
                break;
            }
        }

        if(flag==false) return -1;
        else return ans;
    }
}