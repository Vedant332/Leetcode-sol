class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(boolean[] row : dp){
            Arrays.fill(row,false);
        }
        int count=0;
        for(int L=1;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j=i+L-1;

                if(i==j){
                    dp[i][j]=true;
                }else if(i+1==j){
                    if(s.charAt(i)==s.charAt(j)) dp[i][j]=true;
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) dp[i][j]=true;
                }

                if(dp[i][j]==true){
                    count++;
                }
            }
        }
        return count;
    }
}