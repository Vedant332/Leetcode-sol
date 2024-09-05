class Pair {
    int row;
    int col;
    int dist;

    public Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Early exit if start or end is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n]; // Visited array to track cells
        visited[0][0] = true;  // Mark the start cell as visited
        q.offer(new Pair(0, 0, 1)); // Start BFS from (0, 0) with initial distance 1

        // Directions for 8 possible moves
        int[] dx = {0, 1, 0, -1, 1, -1, -1, 1};
        int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int r = current.row;
            int c = current.col;
            int d = current.dist;

            // If we've reached the bottom-right corner, return the distance
            if (r == n - 1 && c == n - 1) {
                return d;
            }

            // Explore all 8 directions
            for (int i = 0; i < 8; i++) {
                int nrow = r + dx[i];
                int ncol = c + dy[i];

                // Check if the new position is within bounds, not visited, and is not blocked
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && !visited[nrow][ncol] && grid[nrow][ncol] == 0) {
                    visited[nrow][ncol] = true;  // Mark the cell as visited
                    q.offer(new Pair(nrow, ncol, d + 1)); // Add new cell to the queue with updated distance
                }
            }
        }

        return -1;  // If no path was found
    }
}