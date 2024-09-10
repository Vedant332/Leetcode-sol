class Solution {
    public int strStr(String haystack, String needle) {
       int hlen=haystack.length();
       int nlen=needle.length();

       for(int i=0;i<hlen;i++){
        if(haystack.charAt(i)==needle.charAt(0)){
            if(check(haystack,needle,i)) return i;
        }
       }
       return -1;
    }

    public boolean check(String s, String r,int i){
        int j=0;

        while(j<r.length() && i<s.length()){
            if(s.charAt(i)==r.charAt(j)){
                i++;
                j++;
            }else {
                return false;
            }
        }
        return (j==r.length());
    }
}