class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public void dfs(int r, int c, boolean[][] vis, int[][] grid, int m, int n, Queue<Pair> q) {
        vis[r][c] = true;
        q.offer(new Pair(r, c));  
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nrow = r + dx[i];
            int ncol = c + dy[i];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, m, n, q);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        boolean flag = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, visited, grid, m, n, q);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        int steps = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int l = 0; l < size; l++) {
                Pair current = q.poll();
                int currentRow = current.row;
                int currentCol = current.col;

                for (int k = 0; k < 4; k++) {
                    int nrow = currentRow + dx[k];
                    int ncol = currentCol + dy[k];
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !visited[nrow][ncol]) {
                        if (grid[nrow][ncol] == 1) {
                            return steps;  
                        }
                        visited[nrow][ncol] = true;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}