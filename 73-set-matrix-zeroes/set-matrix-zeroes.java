class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
         ArrayList<Integer> row = new ArrayList<Integer>();
    ArrayList<Integer> col = new ArrayList<Integer>(); 

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                   row.add(i);
                   col.add(j);
                }
            }
        }
        for(int it : row){
            makeZeroRow(matrix,it);
        }
        for(int it : col){
            makeZeroCol(matrix,it);
        }

    }

    public void makeZeroRow(int[][] matrix,int row){

        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i]=0;
        }
    }

     public void makeZeroCol(int[][] matrix,int col){

     for(int j=0;j<matrix.length;j++){
            matrix[j][col]=0;
       }
    }
}