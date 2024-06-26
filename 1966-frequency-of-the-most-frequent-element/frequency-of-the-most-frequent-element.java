class Solution {
    public int maxFrequency(int[] nums, int k) {
         Arrays.sort(nums);
        int result = 1;
       int i = 0;
        long currSum = 0;
        for (int j = 0; j < nums.length; j++) {
            long target = nums[j];
            currSum += nums[j];
            while ((j - i + 1) * target - currSum > k) {
                currSum -= nums[i];
                i++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}