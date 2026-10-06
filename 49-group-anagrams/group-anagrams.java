class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            int[] freq=new int[26];
            String word=strs[i];
            for(char c : strs[i].toCharArray()){
                freq[c-'a']++;
            }

            StringBuilder sb=new StringBuilder();
            for(int j=0;j<26;j++){
                while(freq[j]!=0){
                    sb.append((char)('a'+j));
                    freq[j]--; 
                }
            }
            if(!map.containsKey(sb.toString())){
                List<String> temp=new ArrayList<>();
                temp.add(word);
                map.put(sb.toString(),temp);
            }else{
                map.get(sb.toString()).add(word);
            }
        }

        List<List<String>> ans=new ArrayList<>();
        for(List<String> temp : map.values()){
            ans.add(temp);
        }
        return ans;
    }
}