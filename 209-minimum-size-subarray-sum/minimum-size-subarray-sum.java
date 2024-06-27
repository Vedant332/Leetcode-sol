class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int minLen=Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            if(sum<target){
                j++;
            }else if(target<=sum){
                while(target<=sum){
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