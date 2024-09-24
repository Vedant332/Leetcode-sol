class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][n-1]=='O'){
                dfs(board,i,n-1);
            }
        }

        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(board,0,j);
            }

            if(board[m-1][j]=='O'){
                dfs(board,m-1,j);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='Y'){
                    board[i][j]='O';
                }
            }
        }
    }

    public void dfs(char[][] board,int row,int col){
        board[row][col]='Y';

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];

            if(nrow>=0 && nrow < board.length && ncol>=0 && ncol<board[0].length && board[nrow][ncol]=='O' ){
                dfs(board,nrow,ncol);
            }
        }
    }
}