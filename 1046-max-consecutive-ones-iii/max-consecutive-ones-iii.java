class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int maxLen=0;
        while(j<nums.length){
            if(nums[j]==1){
                maxLen=Math.max(j-i+1,maxLen);
                j++;
            }else if(nums[j]==0 && k>0){
               maxLen=Math.max(j-i+1,maxLen);
               k--;
               j++;
            }else{
                while(k==0){
                    if(nums[i]==0){
                        k++;
                    }
                    i++;
                }
            }
        }
        return maxLen;
    }
}