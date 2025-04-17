class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        dp[s1.length()][s2.length()]=true;

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j];
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j] || dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }

    public boolean func(String s1, String s2, String s3,int i,int j,boolean[][] dp){
        if(i==s1.length() && j==s2.length()) return true;

        if(dp[i][j]!=false) return dp[i][j];

        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
            if(func(s1,s2,s3,i+1,j,dp)){
                return dp[i][j]=true;
            }
        }

        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)){
            if(func(s1,s2,s3,i,j+1,dp)){
                return dp[i][j]=true;
            }
        }
        return dp[i][j]=false;
    }
}