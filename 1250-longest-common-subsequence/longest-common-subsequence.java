class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return  func(text1,text2,text1.length(),text2.length(),dp);
    }

    public int func(String text1, String text2,int i,int j,int[][] dp){
        if(i==0||j==0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i-1)==text2.charAt(j-1)){
            return dp[i][j]=1+func(text1,text2,i-1,j-1,dp);
        }else{
            return dp[i][j]=Math.max(func(text1,text2,i-1,j,dp),func(text1,text2,i,j-1,dp));
        }
    }
}