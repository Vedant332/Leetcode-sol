class Solution {
    public boolean canPartition(int[] nums) {
        int totSum=0;
        for(int i=0;i<nums.length;i++){
            totSum+=nums[i];
        }
        if(totSum%2!=0) return false;

        Boolean[][] dp=new Boolean[nums.length][totSum+1];

        return helper(nums,nums.length-1,totSum/2,dp);
    }

    public boolean helper(int[] nums,int ind,int sum,Boolean[][] dp){
        if(ind==0){
            if(sum==nums[ind]) return true;
            else return false;
        }

        if(sum==0) return true;
        if(dp[ind][sum]!=null) return dp[ind][sum];
        boolean notTake=helper(nums,ind-1,sum,dp);
        boolean take=false;
        if(nums[ind]<=sum){
            take=helper(nums,ind-1,sum-nums[ind],dp);
        }
        return dp[ind][sum]=take | notTake;
    }
}