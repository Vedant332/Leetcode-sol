class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int j=matrix[0].length-1;
        int i=0;

        while(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target) {
                i++;
            }
        }
        return false;
    }
}