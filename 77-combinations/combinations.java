class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(1,n,k,ans,new ArrayList<>());
        return ans;
    }

    public void helper(int ind,int n,int k,List<List<Integer>> ans,List<Integer> temp){
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=ind;i<=n;i++){
            temp.add(i);
            helper(i+1,n,k,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}