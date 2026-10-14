class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        Boolean[][] dp=new Boolean[n][n];
        int maxLen=0;
        int start=0;

        for(int L=1;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j=i+L-1;

                if(i==j){
                    dp[i][j]=true;
                }else if(i+1==j){
                    dp[i][j]= (s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j)) && (dp[i+1][j-1]==true);
                }

                if(dp[i][j]==true){
                    maxLen=L;
                    start=i;
                    
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}