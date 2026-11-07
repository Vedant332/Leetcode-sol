class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int n =s.length();

        HashMap<String,Integer> stringmap=new HashMap<>();
        HashMap<Character,Integer> freq=new HashMap<>();
        int j=0;

        for(int i=0;i<n;i++){
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);
            
            if (i-j+1 > minSize) {
                char left=s.charAt(j);
                freq.put(left, freq.get(left) - 1);
                if (freq.get(left)==0) {
                    freq.remove(left);
                }
                j++;
            }
            if (i-j+1 == minSize && freq.size()<=maxLetters) {
                String sub = s.substring(j, i + 1);
                stringmap.put(sub, stringmap.getOrDefault(sub, 0) + 1);
            }
           
        }
        int ans = 0;
        for (int value : stringmap.values()) {
            ans = Math.max(ans, value);
        }
        return ans;
    }
}