class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == '.') continue;
                if(set.contains("r-"+ i + board[i][j]) || set.contains("c-"+ j + board[i][j])|| set.contains("box-" + (i/3) + "-" + (j/3) + "-" + board[i][j] )) return false;
                set.add("r-"+i+board[i][j]);
                set.add("c-"+ j + board[i][j]);
                set.add("box-" + (i/3) + "-" + (j/3) + "-" + board[i][j] );
            }
        }
        return true;
    }
}