class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
         int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start DFS if we find an unvisited part of an island in grid2
                if (grid2[i][j] == 1) {
                    if (dfs(i, j, grid1, grid2)) {
                        count++; // Increment the count if DFS returns true
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int row, int col, int[][] grid1, int[][] grid2) {
        // Boundary conditions
        if (row < 0 || row >= grid1.length || col < 0 || col >= grid1[0].length) {
            return true;
        }

        // If it's water or already visited in grid2, return true (no contradiction)
        if (grid2[row][col] == 0) {
            return true;
        }

        // If grid2 has land but grid1 does not, return false (not a sub-island)
        if (grid1[row][col] == 0) {
            return false;
        }

        // Mark this cell as visited by setting it to 0 in grid2
        grid2[row][col] = 0;

        // Explore all four directions (up, down, left, right)
        boolean up = dfs(row - 1, col, grid1, grid2);
        boolean down = dfs(row + 1, col, grid1, grid2);
        boolean left = dfs(row, col - 1, grid1, grid2);
        boolean right = dfs(row, col + 1, grid1, grid2);

        // Return true only if all directions confirm it's part of a sub-island
        return up && down && left && right;
    }
}