class Solution {
    public int maxArea(int[] height) {
        int maxArea=Integer.MIN_VALUE;
        int l=0;
        int r=height.length-1;

        while(l<r){
            int area=(r-l)*Math.min(height[l],height[r]);
            maxArea=Math.max(area,maxArea);
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return maxArea;
    }
}