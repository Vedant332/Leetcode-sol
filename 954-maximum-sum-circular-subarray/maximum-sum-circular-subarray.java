class Solution {
    public int maxSubarraySumCircular(int[] nums) {
     int sum=0;
     for(int i=0;i<nums.length;i++){
        sum+=nums[i];
     }   

     int minSum=findMinKad(nums);
     int maxSum=findMaxSum(nums);
     int circularSum=sum-minSum;

     if(maxSum>0) return Math.max(maxSum,circularSum);
     return maxSum;
    }

    public int findMaxSum(int[] nums){
         int curr=0;
        int maxSum=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
            maxSum=Math.max(curr,maxSum);
            if(curr<0){
              curr=0;
            }
        }
        return maxSum;
    }

    public int findMinKad(int[] nums){
         int curr=0;
        int minSum=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
            minSum=Math.min(curr,minSum);
            if(curr>0){
              curr=0;
            }
        }
        return minSum;
    }
}