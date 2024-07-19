class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1); 
        return Math.min(helper(0, cost, memo), helper(1, cost, memo));
    }

    private int helper(int ind, int[] cost, int[] memo) {
        if (ind >= cost.length) {
            return 0;
        }
        if (memo[ind] != -1) {
            return memo[ind];
        }
        int oneJump = cost[ind] + helper(ind + 1, cost, memo);
        int twoJump = cost[ind] + helper(ind + 2, cost, memo);
        memo[ind] = Math.min(oneJump, twoJump);
        return memo[ind];
    }
}