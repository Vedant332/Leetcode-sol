class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        Arrays.sort(points, (x, y) -> Integer.compare(x[0], y[0]));
        int[] prev=points[0];
        int count=1;

        for(int i=1;i<n;i++){
            if(prev[1]<points[i][0]){
                count++;
                prev=points[i];
            }else{
                prev[0]=Math.max(prev[0],points[i][0]);
                prev[1]=Math.min(prev[1],points[i][1]);
            }
        }
        return count;
    }
}