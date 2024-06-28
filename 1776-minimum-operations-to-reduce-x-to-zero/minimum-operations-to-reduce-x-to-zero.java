class Solution {
    public int minOperations(int[] nums, int x) {
    //    int sum=0;
    //    for(int i=0;i<nums.length;i++){
    //     sum+=nums[i];
    //    }

    //    int i=0;
    //    int j=0;
    //    int currSum=0;
    //    int maxLen=0;
    //    int minOperations=0;
    //    while(j<nums.length){
    //     currSum+=nums[j];
    //    if(currSum==sum-x){
    //        maxLen=Math.max(maxLen,j-i+1);
    //     }else{
    //         while(currSum>sum-x){
    //             currSum-=nums[i];
    //             i++;
    //         }
    //     }
    //     j++;
    //    }
    //   return minOperations=(nums.length-maxLen);

    int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        if (target < 0) return -1;
        int i = 0, j = 0;
        int currSum = 0;
        int maxLen = -1;
        while (j < nums.length) {
            currSum += nums[j];
            while (currSum > target && i <= j) {
                currSum -= nums[i];
                i++;
            }
            if (currSum == target) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j++;
        }
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}