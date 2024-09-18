class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(word1.length()-1,word2.length()-1,word1,word2,dp);
    }

    public int helper(int i,int j,String word1,String word2,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=0+ helper(i-1,j-1,word1,word2,dp);
        }

        return dp[i][j]=1+Math.min(helper(i-1,j-1,word1,word2,dp),Math.min(helper(i-1,j,word1,word2,dp),helper(i,j-1,word1,word2,dp)));
    }
}