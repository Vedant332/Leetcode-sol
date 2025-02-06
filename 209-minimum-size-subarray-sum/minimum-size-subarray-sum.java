class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int minLen=Integer.MAX_VALUE;
        int sum=0;

        while(j<n){
            sum+=nums[j];

            if(sum<target){
                j++;
            }else if(sum>=target){
               while(sum>=target){
                minLen=Math.min(minLen,j-i+1);
                sum-=nums[i];
                i++;
               }
               j++;
            }
        }
        if(minLen==Integer.MAX_VALUE) return 0;
         else return minLen;
    }
}