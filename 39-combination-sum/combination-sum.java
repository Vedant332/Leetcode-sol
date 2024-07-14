class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,target,0,ans,new ArrayList<>());
        return ans;
    }

    public void helper(int[] candidates,int target,int ind,List<List<Integer>> ans,List<Integer> res){
        if(target==0){
            ans.add(new ArrayList(res));
            return;
        }

        if(ind==candidates.length){
            return;
        }

        if(candidates[ind]<=target){
            res.add(candidates[ind]);
        helper(candidates,target-candidates[ind],ind,ans,res);
        res.remove(res.size()-1);
        }
        helper(candidates,target,ind+1,ans,res);
    }
}