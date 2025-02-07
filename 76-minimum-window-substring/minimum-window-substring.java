class Solution {
    public String minWindow(String s, String t) {
        int[] hashArr=new int[128];
        for(int i=0;i<t.length();i++){
            hashArr[t.charAt(i)]++;
        }
        int l=0;
        int r=0;
        int count=0;
        int minLen=Integer.MAX_VALUE;
        int sIndex=-1;

        while(r<s.length()){
            char c=s.charAt(r);
            if(hashArr[c]>0){
                count++;
            }
            hashArr[c]--;
            while(count==t.length()){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    sIndex=l;
                }

                char ch=s.charAt(l);
                hashArr[ch]++;
                if(hashArr[ch]>0){
                    count--;
                }
                l++;
            }
            r++;
        }
         return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}