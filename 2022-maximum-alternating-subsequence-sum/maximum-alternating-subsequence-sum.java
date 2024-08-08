class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp=new long[nums.length][2];
        for(long[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(nums,0,0,dp);
    }

    public long helper(int[] nums,int ind,int offset,long[][] dp){
        if(ind>=nums.length) return 0;
        
        if(dp[ind][offset]!=-1) return dp[ind][offset];
        long total=0;
        if(offset==0){
            total=nums[ind];
        }else{
            total=-nums[ind];
        }

        long notTake=helper(nums,ind+1,offset,dp);
        long take=total+helper(nums,ind+1,1-offset,dp);

        return dp[ind][offset]=Math.max(notTake,take);
       
    }
}