class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;

        for(int ind=n-1;ind>=0;ind--){
            int count=0;
             for(int i=ind;i<n && i <ind+2;i++){
                String c=s.substring(ind,i+1);
                int num=Integer.parseInt(c);
                if(c.charAt(0)!='0' && num<=26){
                    count+=dp[i+1];
            }
        }
             dp[ind]=count;
        }
        
        return dp[0];
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