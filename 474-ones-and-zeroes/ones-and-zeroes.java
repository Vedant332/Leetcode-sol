class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int size=strs.length;
        int[][][] dp=new int[size+1][m+1][n+1];

        for(int ind=size-1;ind>=0;ind--){
            for(int zeros=0;zeros<m+1;zeros++){
                for(int ones=0;ones<n+1;ones++){
                    String st=strs[ind];
                    int one=findOnes(st);
                    int zero=st.length()-one;

                    int notTake=dp[ind+1][zeros][ones];
                    int take=Integer.MIN_VALUE;
                    if(zeros>=zero && ones>= one){
                        take=1+dp[ind+1][zeros-zero][ones-one];
                    }

                    dp[ind][zeros][ones]=Math.max(take,notTake);
                }
            }
        }

        return dp[0][m][n];
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