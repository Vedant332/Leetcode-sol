class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map1=new HashMap<>();
        HashMap<String,Character> map2=new HashMap<>();

        String[] words=s.split(" ");
        if(words.length!=pattern.length()) return false;

        for(int i=0;i<pattern.length();i++){
            if(map1.containsKey(pattern.charAt(i)) && !map1.get(pattern.charAt(i)).equals(words[i])){
                return false;
            }

            if(map2.containsKey(words[i]) && map2.get(words[i])!=pattern.charAt(i)){
                return false;
            }

            map1.put(pattern.charAt(i),words[i]);
            map2.put(words[i],pattern.charAt(i));
        }
        return true;
    }
}