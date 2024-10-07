class Solution {
    public boolean canPartition(int[] nums) {
        int totSum=0;
        for(int i=0;i<nums.length;i++){
            totSum+=nums[i];
        }
        Boolean[][] dp=new Boolean[nums.length][totSum+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= totSum/2; j++) {
                dp[i][j] = false;  
            }
        }
        if(totSum%2!=0) return false;

        for(int i=0;i<nums.length;i++){
            dp[i][0]=true;
        }
        if (nums[0] <= totSum/2) {
              dp[0][nums[0]] = true;  
        }

        for(int ind=1;ind<nums.length;ind++){
            for(int sum=1;sum<=totSum/2;sum++){
                Boolean notTake=dp[ind-1][sum];
                Boolean take=false;
                if(nums[ind]<=sum){
                    take=dp[ind-1][sum-nums[ind]];
                }
                 dp[ind][sum]=take || notTake;
            }
        }


        return dp[nums.length-1][totSum/2];
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