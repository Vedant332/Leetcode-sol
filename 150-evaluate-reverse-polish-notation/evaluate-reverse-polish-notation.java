class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int n=tokens.length;
        for(int i=0;i<n;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("/") && !tokens[i].equals("*")){
                String s=tokens[i];
                Integer val=Integer.valueOf(s);
                st.push(val);
            }else if(!st.isEmpty() && tokens[i].equals("+")){
                int sec=st.pop();
                int fir=st.pop();
                int ans=fir+sec;
                st.push(ans);
            }else if(!st.isEmpty() && tokens[i].equals("-")){
                int sec=st.pop();
                int fir=st.pop();
                int ans=fir-sec;
                st.push(ans);
            }else if(!st.isEmpty() && tokens[i].equals("*")){
                int sec=st.pop();
                int fir=st.pop();
                int ans=fir*sec;
                st.push(ans);
            }else if(!st.isEmpty() && tokens[i].equals("/")){
                int sec=st.pop();
                int fir=st.pop();
                int ans=fir/sec;
                st.push(ans);
            }
        }
        return st.peek();
    }
}