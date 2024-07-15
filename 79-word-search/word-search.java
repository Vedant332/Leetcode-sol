class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(0,i,j,board,word,vis,m,n)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int ind,int row,int col,char[][] board,String word,boolean[][] vis,int m,int n){
        if (ind == word.length()) {
            return true;
        }
        if (row < 0 || row >= m || col < 0 || col >= n || vis[row][col] || board[row][col] != word.charAt(ind)) {
            return false;
        }

        vis[row][col] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (dfs(ind + 1, nrow, ncol, board, word, vis, m, n)) {
                return true;
            }
        }

        vis[row][col] = false;
        return false;
    }
}