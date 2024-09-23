/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> arr=binaryMatrix.dimensions();
        int row=arr.get(0);
        int col=arr.get(1);
        int minIndex=Integer.MAX_VALUE;
        for(int i=0;i<row;i++){
            int ind=binarySearch(binaryMatrix,i,col);
            minIndex=Math.min(ind,minIndex);
        }
        return (minIndex==Integer.MAX_VALUE) ? -1 : minIndex;
    }

    public int binarySearch(BinaryMatrix binaryMatrix,int row,int col){
        int lo=0;
        int hi=col-1;
        int ind=Integer.MAX_VALUE;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(binaryMatrix.get(row,mid)==1){
                ind=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ind;
    }
}