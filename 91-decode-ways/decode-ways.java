class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return func(0,s,n,dp);
    }

    public int func(int ind, String s,int n,int[] dp){
        if(ind == n) return 1;

        int count=0;
        if(dp[ind]!= -1) return dp[ind];
        for(int i=ind;i<n && i <ind+2;i++){
            String c=s.substring(ind,i+1);
            int num=Integer.parseInt(c);
            if(c.charAt(0)!='0' && num<=26){
                count+=func(i+1,s,n,dp);
            }
        }
        return dp[ind]=count;
    }
}