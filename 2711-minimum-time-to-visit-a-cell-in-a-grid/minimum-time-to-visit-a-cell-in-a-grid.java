class Tuple {
    int r;
    int c;
    int t;
    public Tuple(int r, int c, int t) {
        this.r = r;
        this.c = c;
        this.t = t;
    }
}

class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        PriorityQueue<Tuple> q = new PriorityQueue<>((a, b) -> a.t - b.t);
        boolean[][] visited = new boolean[m][n];
        q.offer(new Tuple(0, 0, 0));
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            int row = curr.r, col = curr.c, time = curr.t;
            if (row == m - 1 && col == n - 1) {
                return time;
            }
            if (visited[row][col]) continue;
            visited[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    int f = (grid[newRow][newCol] - time) % 2 == 0 ? 1 : 0;
                    int newTime = Math.max(time + 1, grid[newRow][newCol] + f);
                    q.offer(new Tuple(newRow, newCol, newTime));
                }
            }
        }
        return -1;
    }
}