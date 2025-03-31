class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int ind=1;ind<nums.length;ind++){
            int take=nums[ind];
             int notTake=dp[ind-1];;
            if(ind>1){
                take+=dp[ind-2];
            }
            
            dp[ind]=Math.max(take,notTake);
        }
        return dp[nums.length-1];
    }

    public int func(int[] nums,int ind,int[] dp){
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1) return dp[ind];

        int take=nums[ind]+func(nums,ind-2,dp);
        int notTake=func(nums,ind-1,dp);

        return dp[ind]=Math.max(take,notTake);
    }
}