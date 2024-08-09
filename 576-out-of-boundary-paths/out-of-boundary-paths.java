class Solution {
  int mod = 1000000007;
    int m;
    int n;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        int[][][] dp = new int[m + 1][n + 1][maxMove + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper( maxMove, startRow, startColumn, dp);
    }

    public int helper(int maxMove, int row, int col, int[][][] dp) {
        if (row == m || col == n || row == -1 || col == -1) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (dp[row][col][maxMove] != -1) {
            return dp[row][col][maxMove];
        }

        int totalPaths = 0;
        totalPaths = (totalPaths + helper( maxMove - 1, row - 1, col, dp)) % mod;
        totalPaths = (totalPaths + helper( maxMove - 1, row, col - 1, dp)) % mod;
        totalPaths = (totalPaths + helper(  maxMove - 1, row + 1, col, dp)) % mod;
        totalPaths = (totalPaths + helper(  maxMove - 1, row, col + 1, dp)) % mod;

        return dp[row][col][maxMove] = totalPaths;
    }
}