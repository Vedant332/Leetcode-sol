class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=map.size();
        int k=s1.length();
        int i=0;
        int j=0;
        while(j<s2.length()){
            if(map.containsKey(s2.charAt(j))){
                map.put(s2.charAt(j),map.get(s2.charAt(j))-1);
                if(map.get(s2.charAt(j))==0){
                    count--;
                }
            }
            if(j-i+1 < k){
                j++;
              }else if(j-i+1 == k){
                if(count==0){
                    return true;
                }

                if(map.containsKey(s2.charAt(i))){
                    map.put(s2.charAt(i),map.get(s2.charAt(i))+1);
                    if(map.get(s2.charAt(i))==1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return false;
    }
}