class Solution {
    private final int[][] grid=new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9},
        {-1,0,-1}
    };
     private int[][][] memo;
      private final int modulo = 1000000007;
    public int knightDialer(int n) {
        int count=0;
        memo = new int[grid.length][grid[0].length][n + 1];
        for (int[][] row : memo) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=-1){
                    count=(count+sol(i,j,n))% modulo;
                }
            }
        }
        return count;
    }

    public int sol(int row,int col,int n){
        if(n-1==0){
            return 1;
        }

        if(memo[row][col][n]!=-1) return memo[row][col][n];

        int[] dx={-2,-2,-1,1,2,2,-1,1};
        int[] dy={-1,1,2,2,1,-1,-2,-2};
        int count=0;
        for(int i=0;i<8;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(isValid(nrow,ncol)){
              count=(count+sol(nrow,ncol,n-1))%modulo;
            }
        }
        return memo[row][col][n]=count;
    }
    public boolean isValid(int i,int j){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)
            return grid[i][j] != -1;
        return false;
    }
}