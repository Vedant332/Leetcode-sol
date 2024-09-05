class Solution {
    public int[] findBuildings(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        int index=n-2;
        while(index>=0){
            if(!st.isEmpty() && heights[index]>heights[st.peek()]  ){
                st.push(index);
            }
            index--;
        }

        int[] ans=new int[st.size()];
        int ind=0;
        while(!st.isEmpty()){
            ans[ind]=st.pop();
            ind++;
        }
        return ans;
    }
}