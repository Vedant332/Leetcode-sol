class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs =new HashSet<>();

        for(int num : nums){
            hs.add(num);
        }

        int maxLen=0;

        int key=0;
        int len=1;

        for(Integer it : hs){
            if(hs.contains(it-1)){
                continue;
            }else{
                key=it;
                len=1;
                while(hs.contains(key+1)){
                    key=key+1;
                    len=len+1;
                }
            }
            maxLen=Math.max(len,maxLen);
        }
        return maxLen;
    }
}