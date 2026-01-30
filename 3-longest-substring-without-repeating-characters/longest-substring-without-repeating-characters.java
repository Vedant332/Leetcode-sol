class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j=0;
        int maxLen=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

            while(map.size()<i-j+1){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j))==0) map.remove(s.charAt(j));
                j++;
            }
            maxLen=Math.max(maxLen,i-j+1);
        }
        return maxLen;
    }
}