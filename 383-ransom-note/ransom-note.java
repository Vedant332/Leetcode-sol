class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }

        for(int i=0;i<ransomNote.length();i++){
            char s=ransomNote.charAt(i);
            if(map.containsKey(s)){
                map.put(s,map.get(s)-1);
                if(map.get(s)==0) map.remove(s);
            }else{
                return false;
            }
        }
        return true;
    }
}