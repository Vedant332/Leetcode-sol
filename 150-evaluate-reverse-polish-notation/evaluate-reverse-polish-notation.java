class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                 String s=tokens[i];
                 Integer val=Integer.valueOf(s);
                 st.push(val);
            }else if(!st.isEmpty() && tokens[i].equals("+")){
                int a=st.pop();
                int b=st.pop();
                 ans=a+b;
                 st.push(ans);
            }else if(!st.isEmpty() && tokens[i].equals("-")){
                int a=st.pop();
                int b=st.pop();
                 ans=b-a;
                 st.push(ans);
            }else if(!st.isEmpty() && tokens[i].equals("*")){
                int a=st.pop();
                int b=st.pop();
                 ans=b*a;
                 st.push(ans);
            }else if(!st.isEmpty() && tokens[i].equals("/")){
                int a=st.pop();
                int b=st.pop();
                 ans=b/a;
                 st.push(ans);
            }
        }
        return st.peek();
    }
}