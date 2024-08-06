class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int it : stones){
            sum+=it;
        }
        int[][] dp=new int[stones.length][sum];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return func(0,0,0,stones,dp);
    }

    public int func(int ind,int sumL,int sumR,int[] stones,int[][] dp){
        if(ind==stones.length){
            return Math.abs(sumL-sumR);
        }

        if(dp[ind][sumL]!=-1) return dp[ind][sumL];

        return dp[ind][sumL]=Math.min(func(ind+1,sumL+stones[ind],sumR,stones,dp),func(ind+1,sumL,sumR+stones[ind],stones,dp));
    }
}