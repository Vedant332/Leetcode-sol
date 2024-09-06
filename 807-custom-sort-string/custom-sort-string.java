class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

       for(int i=0;i<order.length();i++){
           char ch=order.charAt(i);
           if(map.containsKey(ch)){
            int freq=map.get(ch);
            for(int j=0;j<freq;j++){
                sb.append(ch);
            }
            map.remove(ch);
           }
       }

       for(Character it : map.keySet()){
        int freq=map.get(it);
        for(int i=0;i<freq;i++){
                sb.append(it);
            }
       }
       return sb.toString();
    }
}