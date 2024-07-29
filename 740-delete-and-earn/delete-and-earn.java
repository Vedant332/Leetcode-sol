class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxi=0;
        for(int max:nums){
            maxi=Math.max(max,maxi);
        }
        int[] freq=new int[maxi+1];
        for(int num : nums){
            freq[num]++;
        }
        int[] dp=new int[maxi+1];
        Arrays.fill(dp,-1);

        return helper(freq,0,dp);
    }

    public int helper(int[] freq,int ind,int[] dp){
        if(ind>=freq.length) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int take=freq[ind]*ind+helper(freq,ind+2,dp);
        int notTake=helper(freq,ind+1,dp);

        return dp[ind]=Math.max(take,notTake);
    }
}