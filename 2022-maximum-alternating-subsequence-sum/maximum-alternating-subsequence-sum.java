class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp=new long[nums.length][2];
        
        for(int ind=nums.length-1;ind>=0;ind--){
            for(int offset=0;offset<2;offset++){
                long total=0;
                if(offset==0){
                    total=nums[ind];
                }else{
                    total=-nums[ind];
                }

                    long notTake=(ind + 1 < n) ? dp[ind + 1][offset] : 0;
                    long take=(ind + 1 < n) ? total + dp[ind + 1][1 - offset] : total;

                     dp[ind][offset]=Math.max(notTake,take);
            }
        }
        return dp[0][0];
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