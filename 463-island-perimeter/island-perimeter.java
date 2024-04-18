class Solution {
    public int islandPerimeter(int[][] grid) {
        int p=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int currSqPeri=checkSq(i,j,grid);
                    p+=currSqPeri;
                }
            }
        }
        return p;
    }

    public int checkSq(int row,int col,int[][] grid){
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int peri=4;
        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];

            if(nrow>=0 && nrow<grid.length && ncol >=0 && ncol<grid[0].length){
                if(grid[nrow][ncol]==1){
                    peri-=1;
                }
            }
        }
        return peri;
    }
}