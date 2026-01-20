class Solution {
    public String decodeString(String s) {
        Stack<Integer> num=new Stack<>();
        Stack<String> res=new Stack<>();
        String ans="";

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
               int count=0;
               while(Character.isDigit(s.charAt(i))){
                count=10*count + (s.charAt(i)-'0');
                i++;
               }
               num.push(count);
               i--;
            }else if(s.charAt(i)=='['){
                res.push(ans);
                ans="";
            }else if(s.charAt(i)==']'){
                StringBuilder sb=new StringBuilder(res.pop());
                int count=num.pop();
                for(int j=0;j<count;j++){
                    sb.append(ans);
                }
                ans=sb.toString();
            }else{
                ans+=s.charAt(i);;
            }
        }
        return ans;
    }
}