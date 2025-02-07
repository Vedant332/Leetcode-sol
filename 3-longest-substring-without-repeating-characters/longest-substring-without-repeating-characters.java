class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
     int n=s.length();
     int i=0;
     int j=0;
     int maxLen= Integer.MIN_VALUE;

     while(j<n){
        map.put(s.charAt(j), map.getOrDefault( s.charAt(j),0) + 1);

        if(map.size()==j-i+1){
            maxLen=Math.max(maxLen,j-i+1);
        }else if(map.size()<j-i+1){
            while(map.size()<j-i+1){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
        }
        j++;
     }
     if(maxLen==Integer.MIN_VALUE) return 0;
     else return maxLen;
    }
}