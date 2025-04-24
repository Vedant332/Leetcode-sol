class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        int m=word1.length();
        int n=word2.length();
        String str="";

        while(i<m && j<n){
            str+=(word1.charAt(i));
            str+=(word2.charAt(j));
            i++;
            j++;
        }

        while(i<m){
            str+=(word1.charAt(i));
            i++;
        }
        while(j<n){
            str+=(word2.charAt(j));
            j++;
        }
        return str;
    }
}