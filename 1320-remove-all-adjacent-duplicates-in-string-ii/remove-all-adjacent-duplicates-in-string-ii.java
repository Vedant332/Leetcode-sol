class Pair{
    char ele;
    int freq;
    public Pair(char ele, int freq){
        this.ele=ele;
        this.freq=freq;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (st.isEmpty() || st.peek().ele != ch) {
                st.push(new Pair(ch, 1));
            } else{
                st.peek().freq++;
                if (st.peek().freq == k) {
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair p : st) {
            for (int i = 0; i < p.freq; i++) {
                sb.append(p.ele);
            }
        }
        return sb.toString();
    }
}