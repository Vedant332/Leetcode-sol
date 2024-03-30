class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        if(s.length()==1 && (s.charAt(0)=='}' || s.charAt(0)==']' || s.charAt(0)==')')) return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                
                stack.push(')');
            } else if (s.charAt(i)=='{') {
                stack.push('}');
                
            } else if (s.charAt(i)=='[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop()!=s.charAt(i)) {

                return false;
            }
        }
        return stack.isEmpty();
    }
}