class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int up=dp[i-1][j];
                int upleft=0;
                if(j-1>=0){
                    upleft=dp[i-1][j-1];
                }else{
                    upleft=10000;
                }
                int upright=0;
                if(j+1<n){
                    upright=dp[i-1][j+1];
                }else{
                    upright=10000;
                }
                dp[i][j]=matrix[i][j]+Math.min(up,Math.min(upleft,upright));
            }
        }
        int mini=10000;
        for(int i=0;i<n;i++){
            mini=Math.min(mini,dp[m-1][i]);
        }
        return mini;
    }

    public int helper(int[][] arr,int i,int j,int[][] dp){
        if(j<0 || j>=arr[0].length) return 10000;
        if(i==0) return arr[i][j];

        if(dp[i][j]!=-1) return dp[i][j];
        int up=helper(arr,i-1,j,dp);
        int upleft=helper(arr,i-1,j-1,dp);
        int upright=helper(arr,i-1,j+1,dp);

        dp[i][j]=arr[i][j]+Math.min(up,Math.min(upleft,upright));

        return dp[i][j];
    }
}