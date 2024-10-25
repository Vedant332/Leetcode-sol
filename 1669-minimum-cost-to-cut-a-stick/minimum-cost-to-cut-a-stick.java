class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(0);
        arr.add(n);
        for(int i=0;i<cuts.length;i++){
            arr.add(cuts[i]);
        }
        Collections.sort(arr);
        int[][] dp=new int[cuts.length+2][cuts.length+2];
        
        for(int i=cuts.length;i>=1;i--){
            for(int j=i;j<=cuts.length;j++){
                int minCost=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cost=arr.get(j+1)-arr.get(i-1)+dp[i][k-1] +dp[k+1][j];
                    minCost=Math.min(cost,minCost);
                }
                 dp[i][j]=minCost;
            }
        }
        return dp[1][cuts.length];
    }

    public int func(ArrayList<Integer> arr,int i,int j,int[][] dp){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int minCost=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost=arr.get(j+1)-arr.get(i-1)+func(arr,i,k-1,dp) +func(arr,k+1,j,dp);
            minCost=Math.min(cost,minCost);
        }
        return dp[i][j]=minCost;
    }
}