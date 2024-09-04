class Solution {
    public int maxDepth(String s) {
        int count=0;
        int res=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }else if(s.charAt(i)==')'){
                count--;
            }
            res=Math.max(res,count);
        }
        return res;
    }
}