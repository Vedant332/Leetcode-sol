class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n=s.length();
        Integer[][] dp=new Integer[n][n];
        for(Integer[] row : dp){
            Arrays.fill(row,-1);
        }
        return func(s,0,n-1,dp)<=k;
    }

    public int func(String s,int start,int end,Integer[][] dp){
        if(start>=end){
            return 0;
        }
         if (dp[start][end] != -1) { 
            return dp[start][end];
        }

        if(s.charAt(start)==s.charAt(end)){
             dp[start][end]=func(s,start+1,end-1,dp);
        }else{
            dp[start][end]=1+Math.min(func(s,start+1,end,dp),func(s,start,end-1,dp));
        }

        return dp[start][end];

    }
}