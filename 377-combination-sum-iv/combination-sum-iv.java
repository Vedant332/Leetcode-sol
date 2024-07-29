class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int []dp= new int[target+1]; 
        Arrays.fill(dp,-1);
        dp[0]=1;
        for(int tar=1;tar<target+1;tar++){
            int ans=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]<=tar){
              ans+=dp[tar-nums[i]];
           }
        }
        dp[tar]=ans;
        }
        return dp[target];
    }

    public int helper(int[] nums,int target,int[] dp){

        if(target<0) return 0;
        if(target==0) return 1;

        if(dp[target]!=-1) return dp[target];
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=helper(nums,target-nums[i],dp);
        }

        return dp[target]=ans;
    }
}