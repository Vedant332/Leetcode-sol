class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] dp=new int[nums.length];
       Arrays.fill(dp,1);
       int ans=0;
       for(int i=0;i<nums.length;i++){
        for(int j=0;j<i;j++){
            if(nums[j]<nums[i] && 1+dp[j]>=dp[i]){
                dp[i]=1+dp[j];
            }
        }
        ans=Math.max(dp[i],ans);
       }
       return ans;
    }
}