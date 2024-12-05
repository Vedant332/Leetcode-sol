class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str1.length()<str2.length()) return false;
        int j=0;
       for(int i=0;i<str1.length();i++){
        if(j<str2.length()){
            char letter = str1.charAt(i);
                char target = str2.charAt(j);
                if(letter==target){
                    j++;
                }else{
                    char newLetter = (char)(((letter - 'a' + 1) % 26) + 'a');
                    if(newLetter==target){
                        j++;
                    }
                }
        }
       }
       return (j==str2.length());
    }
}