class Solution {
    public int strStr(String haystack, String needle) {
        int l=haystack.length();
        int r=needle.length();

        for(int i=0;i<l;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(check(haystack,needle,i)) return i;
            }
        }
        return -1;
    }

    public boolean check(String haystack, String needle,int i){
        int j=0;

        while(j<needle.length() && i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                return false;
            }
        }
        return (j==needle.length());
    }
}