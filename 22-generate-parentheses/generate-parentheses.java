class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        helper(n,n,ans,"");
        return ans;
    }

    public void helper(int open,int close,List<String> ans, String temp){
        if(open==0 && close==0) {
            ans.add(temp);
            return;
        }

        if(open>0){
            helper(open-1,close,ans,temp+"(");
        }

        if(close>open){
            helper(open,close-1,ans,temp+")");
        }
    }
}