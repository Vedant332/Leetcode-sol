class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element=st.pop();
                int pse=(st.isEmpty()) ? -1 : st.peek();
                maxArea=Math.max(maxArea,heights[element]*(i-pse-1));
            }            
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse=n;
            int ele=st.pop();
            int pse=(st.isEmpty()) ? -1 : st.peek();
            maxArea=Math.max(maxArea,heights[ele]*(nse-pse-1));
        }
        return maxArea;
    }
}