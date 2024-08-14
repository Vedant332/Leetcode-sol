class Solution {

    public int[] findCoordinates(int currentPosition, int n){
        int r = n - (currentPosition - 1) / n - 1;
        int c = (currentPosition - 1) % n;
        if (r % 2 == n % 2) return new int[]{r, n - 1 - c};
        else return new int[]{r, c};
    }
   

    public int snakesAndLadders(int[][] board) {
        int steps = 0;
        int n = board.length;
        int end = n * n;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();
        
        visited[n - 1][0] = true;
        q.add(1); 
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int currPos = q.poll();
                if (currPos == end) return steps; 
                
                for (int j = 1; j <= 6; j++) {
                    if (currPos + j > end) break;
                    int[] nextPos = findCoordinates(currPos + j, n);
                    int row = nextPos[0];
                    int col = nextPos[1];
                    
                    if (!visited[row][col]) {
                        visited[row][col] = true;
                        if (board[row][col] != -1) {
                            q.add(board[row][col]);
                        } else {
                            q.add(currPos + j);
                        }
                    }
                }
            }
            steps++;  
        }
        return -1;
    }
}