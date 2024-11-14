class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int maxLen=0;
        int zeros=0;

        while(j<nums.length){
            if(nums[j]==0) zeros++;
            while(zeros>k){
                if(nums[i]==0) zeros--;
                i++;
            }
            int len=j-i+1;
            maxLen=Math.max(maxLen,len);
            j++;
        }
        return maxLen;
    }
}