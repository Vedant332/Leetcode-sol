class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && k>0 && st.peek()-'0' > num.charAt(i)-'0'){
                st.pop();
                k=k-1;
            }
            st.push(num.charAt(i));
        }

        while(k>0){
            st.pop();
            k=k-1;
        }

        if(st.isEmpty()) return "0";

        StringBuilder sb=new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        while(sb.toString().startsWith("0")){
            sb.deleteCharAt(0);
        }
        if(sb.length()==0) return "0";

        return sb.toString();

    }
}