class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] arr=new int[scores.length][2];

        for(int i=0;i<scores.length;i++){
            arr[i][0]=scores[i];
            arr[i][1]=ages[i];
        }
         Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

         int[][] dp=new int[scores.length+1][scores.length+1];
         for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i <= scores.length; i++) {
            dp[scores.length][i] = 0;
        }

        for(int ind=scores.length-1;ind>=0;ind--){
            for(int prev=scores.length-1;prev>=-1;prev--){
                int take=0;
        if(prev==-1 || arr[ind][0]>=arr[prev][0]){
             take=arr[ind][0]+dp[ind+1][ind+1];
        }
        int notTake=dp[ind+1][prev+1];

         dp[ind][prev+1]=Math.max(take,notTake);
            }
        }

        return dp[0][-1+1];
    }

    public int helper(int[][] arr,int ind,int prev,int[][] dp){
        if(ind==arr.length) return 0;

        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];

        int take=0;
        if(prev==-1 || arr[ind][0]>=arr[prev][0]){
             take=arr[ind][0]+helper(arr,ind+1,ind,dp);
        }
        int notTake=helper(arr,ind+1,prev,dp);

        return dp[ind][prev+1]=Math.max(take,notTake);
    }
}