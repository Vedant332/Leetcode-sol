class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] arr=path.split("/");
        for(String it : arr){
            if(!st.isEmpty() && it.equals("..")){
                st.pop();
            }else if(!it.equals(".") && !it.equals("..") &&!it.equals("")){
                st.push(it);
            }
        }
        return "/"+ String.join("/",st);
    }
}