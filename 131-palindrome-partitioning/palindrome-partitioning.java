class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        helper(s,0,new ArrayList<>(),ans);
        return ans;
    }

    public void helper(String s,int ind,List<String> res,List<List<String>> ans){
        if(ind==s.length()){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalin(ind,i,s)){
                res.add(s.substring(ind,i+1));
                helper(s,i+1,res,ans);
                res.remove(res.size()-1);
            }
        }
    }
     public boolean isPalin(int start, int end, String s){
        
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
}
}