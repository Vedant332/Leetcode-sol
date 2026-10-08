class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,candidates,new ArrayList<>(),ans,target);
        return ans;
    }
    public void helper(int ind,int[] candidates,List<Integer> temp,List<List<Integer>> ans,int target){
        if (target < 0) return;
        if (ind == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        } 

        temp.add(candidates[ind]);
        helper(ind,candidates,temp,ans,target-candidates[ind]);
        temp.remove(temp.size()-1);
        helper(ind+1,candidates,temp,ans,target);
        
    }
}