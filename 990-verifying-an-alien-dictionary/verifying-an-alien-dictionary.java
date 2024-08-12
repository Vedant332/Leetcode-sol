class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }

        for(int j=1;j<words.length;j++){
            char[] curr=words[j].toCharArray();
            char[] prev=words[j-1].toCharArray();
            int i=0;
            while(i<prev.length && i<curr.length){
                if(map.get(prev[i])<map.get(curr[i])){
                    break;
                }else if(map.get(prev[i])>map.get(curr[i])){
                    return false;
                }
                i++;
            }
            if(i<prev.length && i==curr.length) return false;
        }
        return true;
    }
}