class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int maxLen=0;
        while(j<s.length()){
            char c=s.charAt(j);
            if(map.containsKey(c)){
                if(map.get(c)>=i){
                    i=map.get(c)+1;
                }
            }
            int len=j-i+1;
            maxLen=Math.max(maxLen,len);
            map.put(c,j);
            j++;
        }
        return maxLen;
    }
}