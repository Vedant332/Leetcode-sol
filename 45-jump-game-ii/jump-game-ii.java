class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int currMax=0;
        int reachable=0;
        int jumps=0;
        for(int i=0;i<nums.length;i++){
           reachable=Math.max(reachable,i+nums[i]);
           if(i==currMax){
            jumps++;
            currMax=reachable;

            if(currMax>=nums.length-1) break;
           }
        }
        return jumps;
    }
}