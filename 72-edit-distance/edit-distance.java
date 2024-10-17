class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return func(m,n,word1,word2,dp);
    }

    public int func(int i,int j,String s, String t,int[][] dp){
        if(i==0) return j;
        if(j==0) return i;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i-1)==t.charAt(j-1)){
            return func(i-1,j-1,s,t,dp);
        }

        return dp[i][j]=1+Math.min(func(i-1,j-1,s,t,dp),Math.min(func(i-1,j,s,t,dp),func(i,j-1,s,t,dp)));
    }
}