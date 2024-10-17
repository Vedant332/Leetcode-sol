class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
         int m=str1.length();
         int n=str2.length();
         int[][] dp=new int[m+1][n+1];

     for(int i=1;i<m+1;i++){
        for(int j=1;j<n+1;j++){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
             dp[i][j]=1+dp[i-1][j-1];
        }else{
            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        }
        }
     }
     
     String ans="";

     int i=m;
     int j=n;

     while(i>0 && j>0){
        if(str1.charAt(i-1)==str2.charAt(j-1)){
            ans+=str1.charAt(i-1);
            i--;
            j--;
        }else if(dp[i-1][j]>dp[i][j-1]){
            ans+=str1.charAt(i-1);
            i--;
        }else{
            ans+=str2.charAt(j-1);
            j--;
        }
     } 

     while(i>0){
        ans+=str1.charAt(i-1);
        i--;
     }

     while(j>0){
        ans+=str2.charAt(j-1);
        j--;
     }

     String ans2=new StringBuilder(ans).reverse().toString();
     return ans2;
    }
}