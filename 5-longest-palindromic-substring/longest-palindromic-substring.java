class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        String[][] dp=new String[s.length()][s.length()];

        for(String[] row: dp){
            Arrays.fill(row,null);
        }

        return func(s,0,s.length()-1,dp);
    }

    public String func(String s,int start,int end,String[][] dp){
        if(start>end){
            return "";
        }

        if(s.charAt(start)==s.charAt(end) && isPalindrome(s,start+1,end-1)){
            return s.substring(start,end+1);
        }

        if(dp[start][end]!=null) return dp[start][end];

        String right=func(s,start+1,end,dp);
        String left=func(s,start,end-1,dp);

        return dp[start][end]=right.length() > left.length()?right:left;
    }

    public boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}