class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     int m=text1.length();
     int n=text2.length();
     int[][] dp=new int[m+1][n+1];

     for(int i=1;i<m+1;i++){
        for(int j=1;j<n+1;j++){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
             dp[i][j]=1+dp[i-1][j-1];
        }else{
            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        }
        }
     }
     
     return dp[m][n];
    }

    public int func(int i,int j,String s,String r,int[][] dp){
        if(i==0 || j==0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i-1)==r.charAt(j-1)){
            return dp[i][j]=1+func(i-1,j-1,s,r,dp);
        }

        return dp[i][j]=Math.max(func(i-1,j,s,r,dp),func(i,j-1,s,r,dp));
    }
}