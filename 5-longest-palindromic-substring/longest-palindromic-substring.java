class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int maxLen=0;
        int ind=0;
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
            maxLen=1;
        }

        for(int L=2;L<=s.length();L++){
            for(int i=0;i+L-1<s.length();i++){
                int j=i+L-1;
                if(s.charAt(i)==s.charAt(j) && L==2){
                    dp[i][j]=true;
                    maxLen=2;
                    ind=i;
                }else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                    dp[i][j]=true;
                    if(maxLen<j-i+1){
                        maxLen=j-i+1;
                        ind=i;
                    }
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return s.substring(ind,ind+maxLen);
    }
}