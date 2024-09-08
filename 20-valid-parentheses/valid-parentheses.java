class Solution {
    public boolean isValid(String s) {
        if(s.charAt(0)==')' || s.charAt(0)==']' || s.charAt(0)=='}') return false;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='('){
            st.push(')');
           }else if(s.charAt(i)=='['){
            st.push(']');
           }else if(s.charAt(i)=='{'){
            st.push('}');
           }else{
            if(!st.isEmpty() && st.peek()==s.charAt(i)){
                st.pop();
            }else return false;
           }
        }
        if(st.size()==0) return true;
        else return false;
    }
}