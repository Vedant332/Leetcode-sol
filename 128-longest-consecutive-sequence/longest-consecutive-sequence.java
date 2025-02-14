class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> hs=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }

        int len=0;
        int maxLen=Integer.MIN_VALUE;
        int key=0;

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