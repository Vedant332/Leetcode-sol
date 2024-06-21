class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1="";
        String s2="";

        for(int i=0;i<word1.length;i++){
            s1+=word1[i];
        }

        for(int i=0;i<word2.length;i++){
            s2+=word2[i];
        }

        int i=0;
        int j=0;

        while(i<s1.length() && j<s2.length ()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else{
                return false;
            }
        }

         return (i==s1.length ()&& j==s2.length());

    }
}