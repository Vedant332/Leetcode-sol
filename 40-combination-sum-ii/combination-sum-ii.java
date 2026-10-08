class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,new ArrayList<>(),ans,candidates,target);
        return ans;
    }
    public void helper(int ind,List<Integer> temp,List<List<Integer>> ans,int[] candidates,int target){
         if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(ind==candidates.length || target<0){
            return;
        }

        for(int i=ind;i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1]){
                continue;
            }
                 temp.add(candidates[i]);
                helper(i+1,temp,ans,candidates,target-candidates[i]);
                temp.remove(temp.size()-1);
        }
    }
}