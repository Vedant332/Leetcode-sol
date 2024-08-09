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

                int u=matrix[i][j]+dp[i-1][j];

                int ld=matrix[i][j];
                if(j-1>=0) ld+=dp[i-1][j-1];
                else ld+=10000;

                int rd=matrix[i][j];
                if(j+1<n) rd+=dp[i-1][j+1];
                else rd+=10000;

                dp[i][j]=Math.min(ld,Math.min(u,rd));
            }
        }
        int mini=10000;
        for(int j=0;j<n;j++){
            mini=Math.min(mini,dp[m-1][j]);
        }
        return mini;
    }

    public static int helper(int i,int j,int[][] arr,int m,int n,int[][] dp){
        if(j<0 || j>=n) return 10000;

        if(i==0) return arr[i][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int ld=arr[i][j]+helper(i-1,j,arr,m,n,dp);
        int u=arr[i][j]+helper(i-1,j-1,arr,m,n,dp);
        int rd=arr[i][j]+helper(i-1,j+1,arr,m,n,dp);

        return dp[i][j]=Math.min(ld,Math.min(u,rd));
    }
}