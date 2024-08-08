class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int size=strs.length;
        int[][][] dp=new int[size+1][m+1][n+1];

        for (int i = 0; i <= strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(strs,m,n,0,dp);
    }

    public int helper(String[] strs,int m, int n,int ind,int[][][] dp){
        if(ind== strs.length) return 0;

        if(dp[ind][m][n]!=-1) return dp[ind][m][n];
        String st=strs[ind];
        int ones=findOnes(st);
        int zeros=st.length()-ones;

        int notTake=helper(strs,m,n,ind+1,dp);
        int take=Integer.MIN_VALUE;
        if(m>=zeros && n>= ones){
            take=1+helper(strs,m-zeros,n-ones,ind+1,dp);
        }

        return dp[ind][m][n]=Math.max(take,notTake);
    }

    public int findOnes(String s){
        int ct=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                ct++;
            }
        }
        return ct;
    }
}