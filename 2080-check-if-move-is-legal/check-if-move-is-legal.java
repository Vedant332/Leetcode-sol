class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        return  dfs(board, rMove, cMove, color, 1, 1,1)    
      || dfs(board, rMove, cMove, color, 1, -1, 1)
      || dfs(board, rMove, cMove, color, 1, 0, 1)
      || dfs(board, rMove, cMove, color, 0, -1, 1)
      || dfs(board, rMove, cMove, color, 0, 1, 1)
      || dfs(board, rMove, cMove, color, -1, -1, 1)
      || dfs(board, rMove, cMove, color, -1, 0, 1)
      || dfs(board, rMove, cMove, color, -1, 1, 1);
    }

    public boolean dfs(char[][] board, int rMove, int cMove, char color,int r2,int c2,int count){
        rMove+=r2;
        cMove+=c2;

        count=count+1;

        if (rMove < 0 || cMove < 0 || rMove >= 8 || cMove >= 8 ) return false;

        if(board[rMove][cMove]==color){
            if(count>=3) return true;
            else return false;
        }else{
            if(board[rMove][cMove]=='.') return false;
            else return dfs(board,rMove,cMove,color,r2,c2,count);
        }
    }
}