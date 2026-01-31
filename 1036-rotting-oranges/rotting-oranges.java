class Pair{
    int row;
    int col;
    int time;
    public Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[m][n];

        int fresh = 0;

        // Step 1: push all initially rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = 1;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;
        int rottenCount = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            time = cur.time; 

            for (int i = 0; i < 4; i++) {
                int nr = cur.row + dx[i];
                int nc = cur.col + dy[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                    grid[nr][nc] == 1 && vis[nr][nc] == 0) {

                    vis[nr][nc] = 1;
                    rottenCount++;
                    q.offer(new Pair(nr, nc, cur.time + 1));
                }
            }
        }
        if (rottenCount != fresh) return -1;

        return time;
    }
}