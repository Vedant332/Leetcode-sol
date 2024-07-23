class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
    
        return Math.max(func(nums,0,nums.length-2,dp1),func(nums,1,nums.length-1,dp2));
    }

    public int func(int[] nums,int start,int end,int[] dp){
        if(end<start){
            return 0;
        }
        if(end==start){
            return nums[start];
        }

        if(dp[end]!=-1) return dp[end];


        int take=nums[end]+func(nums,start,end-2,dp);
        int notTake=func(nums,start,end-1,dp);

        return dp[end]=Math.max(take,notTake);
    }
}