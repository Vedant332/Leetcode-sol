class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,0,ans,target,new ArrayList<>());
        return ans;
    }

    public void helper(int[] candidates,int ind,List<List<Integer>> ans,int target,List<Integer> res){
         if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=ind;i<candidates.length;i++){
            if(i!=ind && candidates[i-1]==candidates[i]) continue;
            if(candidates[i]<=target){
            res.add(candidates[i]);
            helper(candidates,i+1,ans,target-candidates[i],res);
            res.remove(res.size()-1);
            }
        }
    }
}