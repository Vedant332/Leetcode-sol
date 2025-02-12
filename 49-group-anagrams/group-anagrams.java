class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();

        for(String word : strs){
            char[] temp=word.toCharArray();
            Arrays.sort(temp);
            String newWord=new String(temp);
            if(!map.containsKey(newWord)){
                map.put(newWord,new ArrayList<>());
            }
            map.get(newWord).add(word);
        }

        List<List<String>> res=new ArrayList<>();

        for(List<String> it : map.values()){
            res.add(it);
        }
        return res;
    }
}