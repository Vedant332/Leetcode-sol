class Solution {
    public int calculate(String s) {
        Stack<Integer> st= new Stack<>();
        int number=0;
        char operator='+';

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                number= (number*10) + (ch-'0');
            }

            if(!Character.isDigit(ch) && ch !=' '|| i== s.length()-1){
                if(operator=='+'){
                    st.push(number);
                }else if(operator=='-'){
                    st.push(-number);
                }else if(operator=='*'){
                    st.push(number*st.pop());
                }else{
                    st.push(st.pop()/number);
                }
                operator=ch;
                number=0;
            }
        }

        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }

        return sum;
    }
}