class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int maxLen=0;
        int maxFreq=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<s.length()){
            char c=s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq=Math.max(map.get(c),maxFreq);
            if((j-i+1)-maxFreq<=k){
                maxLen=Math.max(maxLen,j-i+1);
                j++;
            }else{
                while((j-i+1)-maxFreq>k){
                    char ch=s.charAt(i);
                    map.put(ch,map.get(ch)-1);
                    if(map.get(ch)==0) map.remove(ch);
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
}