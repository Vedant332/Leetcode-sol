class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int[][] vis=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && word.charAt(0)==board[i][j]){
                    if(dfs(i,j,board,word,vis,m,n,1)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int row,int col,char[][] board,String word,int[][] vis,int m,int n,int wordInd){
         if(wordInd==word.length()) return true;
         vis[row][col]=1;  
       
        int[] dx={0,-1,0,1};
        int[] dy={-1,0,1,0};
        for(int i=0;i<4;i++){
            int nrow=dx[i]+row;
            int ncol=dy[i]+col;
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]!=1 && board[nrow][ncol]==word.charAt(wordInd)){
                if(dfs(nrow,ncol,board,word,vis,m,n,wordInd+1)){
                    return true;
                }
            }
        }
        vis[row][col] = 0;
        return false;
    }
}