class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp=new long[questions.length+1];
        // Arrays.fill(dp,-1);

        dp[questions.length]=0;

        for(int ind=questions.length-1;ind>=0;ind--){
            long take=questions[ind][0];
            if(ind+1+questions[ind][1]<questions.length){
                 take+=dp[ind+1+questions[ind][1]];
            }
            long notTake=dp[ind+1];

         dp[ind]=Math.max(take,notTake);
        }
        return dp[0];
    }

    public long helper(int[][] questions,int ind,long[] dp){
        if(ind>=questions.length) return 0;

        if(dp[ind]!=-1) return dp[ind];

        long take=questions[ind][0]+helper(questions,ind+questions[ind][1],dp);
        long notTake=helper(questions,ind+1,dp);

        return dp[ind]=Math.max(take,notTake);
    }
}