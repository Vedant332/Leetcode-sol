class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     int m=text1.length();
     int n=text2.length();
     int[][] dp=new int[m+1][n+1];
     for(int[] row : dp){
        Arrays.fill(row,-1);
     }   
     return func(m,n,text1,text2,dp);
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