class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        Arrays.fill(dp,-1);

        dp[s.length()]=1;
        for(int j=s.length()-1;j>=0;j--){
            int count=0;
        for(int i=j;i<Math.min(j + 2, s.length());i++){
            if(isValid(s.substring(j,i+1))){
                count+=solve(s,i+1,dp);
            }
        }
         dp[j]=count;
        }
        return dp[0];
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