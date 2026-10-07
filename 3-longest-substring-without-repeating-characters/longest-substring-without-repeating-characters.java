class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int maxLen=0;
        int l=0;
        for(int i=0;i<s.length();i++){
            while(map.containsKey(s.charAt(i))){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0) map.remove(s.charAt(l));
                l++;
            }
            maxLen=Math.max(maxLen,i-l+1);
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        return maxLen;
    }
}