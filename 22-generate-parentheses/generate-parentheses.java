class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans=new ArrayList<>();
        helper(ans,"",n,n);
        return ans;
    }

    public void helper(ArrayList<String> ans,String s, int o,int c){
        if(o==0 && c==0){
            ans.add(s);
            return;
        }

        if(o>0) helper(ans,s+'(',o-1,c);
        if(c>o) helper(ans,s+')',o,c-1);
    }
}