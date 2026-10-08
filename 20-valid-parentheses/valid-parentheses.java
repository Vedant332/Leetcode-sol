class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();

        for(int i=0;i<n;i++){
            if(!st.isEmpty() && s.charAt(i)==')'){
                if(st.peek()=='(') st.pop();
                else return false;
            }else if(!st.isEmpty() && s.charAt(i)==']'){
                if(st.peek()=='[') st.pop();
                else return false;
            }else if(!st.isEmpty() && s.charAt(i)=='}'){
                if(st.peek()=='{') st.pop();
                else return false;
            }else{
                st.push(s.charAt(i));
            }
        }
        return (st.size()==0);
    }
}