class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int i=0;
        int j=n-1;
        int area =0;
        int maxArea=Integer.MIN_VALUE;

        while(i<j){
            area=Math.min(height[i],height[j]) * (j-i);
            maxArea=Math.max(area,maxArea);

            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxArea;
    }
}