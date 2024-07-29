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

        dp[0]=0;
        dp[1]=freq[1];

        for(int i=2;i<freq.length;i++){
            int take=freq[i]*i+dp[i-2];
        int notTake=dp[i-1];

         dp[i]=Math.max(take,notTake);
        }

        return dp[maxi];
    }

    public int helper(int[] freq,int ind,int[] dp){
        if(ind>=freq.length) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int take=freq[ind]*ind+helper(freq,ind+2,dp);
        int notTake=helper(freq,ind+1,dp);

        return dp[ind]=Math.max(take,notTake);
    }
}