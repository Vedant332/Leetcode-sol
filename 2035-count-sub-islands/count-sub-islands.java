class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
         int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(i, j, grid1, grid2)) {
                        count++; 
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int row, int col, int[][] grid1, int[][] grid2) {
        if (row < 0 || row >= grid1.length || col < 0 || col >= grid1[0].length) {
            return true;
        }
        if (grid2[row][col] == 0) {
            return true;
        }
        if (grid1[row][col] == 0) {
            return false;
        }
        grid2[row][col] = 0;
        boolean up = dfs(row - 1, col, grid1, grid2);
        boolean down = dfs(row + 1, col, grid1, grid2);
        boolean left = dfs(row, col - 1, grid1, grid2);
        boolean right = dfs(row, col + 1, grid1, grid2);
        return up && down && left && right;
    }
}