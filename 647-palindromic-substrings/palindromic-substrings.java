    class Solution {
            public int countSubstrings(String s) {
            int count=0;
            boolean[][] dp=new boolean[s.length()][s.length()];

            for(int i=0;i<s.length();i++){
                for(int j=i;j<s.length();j++){
                    if(isPalindrome(s,i,j,dp)){
                        count++;
                    }
               }
          }
            return count;
   }

    public boolean isPalindrome(String s, int start,int end,boolean[][] dp){
        if(start>=end) return true;

        if (dp[start][end] == true) return dp[start][end];
       if(s.charAt(start)==s.charAt(end)){
        return  dp[start][end] = isPalindrome(s, start + 1, end - 1, dp);
       }
       

       return dp[start][end]=false;
    }
}