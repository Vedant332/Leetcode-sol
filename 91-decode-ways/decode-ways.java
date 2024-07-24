class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0,dp);
    }

    public int solve(String s,int ind,int[] dp){
        if(ind==s.length()){
            return 1;
        }

        if(dp[ind]!=-1)return dp[ind];

        int count=0;
        for(int i=ind;i<Math.min(ind + 2, s.length());i++){
            if(isValid(s.substring(ind,i+1))){
                count+=solve(s,i+1,dp);
            }
        }
        return dp[ind]=count;
    }

    public boolean isValid(String s){
        if(s.startsWith("0")) return false;
        int num=Integer.parseInt(s);
        return num>0 && num<=26;
    }
}