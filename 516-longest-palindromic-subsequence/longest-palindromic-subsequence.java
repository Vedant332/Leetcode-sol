class Solution {
    public int longestPalindromeSubseq(String s) {
       String r=reverse(s);
       return LCS(s,r);
    }

     public int LCS(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        
        for(int i=1;i<text1.length()+1;i++){
            for(int j=1;j<text2.length()+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
             dp[i][j]=1+dp[i-1][j-1];
        }else{
             dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        }
            }
        }
        return  dp[text1.length()][text2.length()];
    }

    public String reverse(String s){
        char[] charArray = s.toCharArray();
        int i=0;
        int j=s.length()-1;
         while (i < j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            
            i++; 
            j--; 
        }
        return new String(charArray);
    }
}