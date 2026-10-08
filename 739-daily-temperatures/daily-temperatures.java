class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans=new int[temperatures.length];
        Stack<Integer> st=new Stack<>();
        int n=temperatures.length;
        ans[n-1]=0;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            if(!st.isEmpty() && temperatures[st.peek()] > temperatures[i] ){
                ans[i]=st.peek()-i;
            }else{
                while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                    st.pop();
                }
                if(!st.isEmpty()) ans[i]=st.peek()-i;
            }
            st.push(i);
        }
        return ans;
    }
}