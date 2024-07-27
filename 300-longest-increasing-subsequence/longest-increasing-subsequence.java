class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int maxi=0;

        for(int ind=0;ind<nums.length;ind++){
            for(int prev=0;prev<ind;prev++){
                if(nums[prev]<nums[ind]){
                    dp[ind]=Math.max(dp[ind],1+dp[prev]);
                }
            }
            maxi=Math.max(dp[ind],maxi);
        }
        return maxi;
    }
}