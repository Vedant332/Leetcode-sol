class Solution {
    public int longestBeautifulSubstring(String word) {
        int maxLen=0;
        int vowels=1;

        int i=0;

        for(int j=1;j<word.length();j++){
            if(word.charAt(j)<word.charAt(j-1)){
                i=j;
                vowels=1;
            }else if(word.charAt(j)>word.charAt(j-1)){
                vowels++;
            }

            if(vowels==5){
                maxLen=Math.max(j-i+1,maxLen);
            }
        }
        return maxLen;

        
    }
}