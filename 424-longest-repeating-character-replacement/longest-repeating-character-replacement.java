class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int maxFreq=0;
        int maxLen=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            maxFreq=Math.max(maxFreq,map.get(s.charAt(j)));
            if((j-i+1)-maxFreq<=k){
                maxLen=Math.max(j-i+1,maxLen);
                j++;
            }else{
                while((j-i+1)-maxFreq>k){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
}