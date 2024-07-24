class Solution {
    public int coinChange(int[] coins, int amount) {
       int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        int ans = solve(coins, n - 1, amount, dp);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    public int solve(int[] arr,int ind,int T,int[][] dp){
       if (ind == 0) {
            if (T % arr[0] == 0)
                return T / arr[0];
            else
                return (int) Math.pow(10, 9);
        }
        if (dp[ind][T] != -1)
            return dp[ind][T];
        int notTaken = 0 + solve(arr, ind - 1, T, dp);
        int taken = (int) Math.pow(10, 9);
        if (arr[ind] <= T)
            taken = 1 + solve(arr, ind, T - arr[ind], dp);
        return dp[ind][T] = Math.min(notTaken, taken);
    }
}