class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        helper(candidates,0,target,result,new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates,int startIndex,int target,List<List<Integer>> result,List<Integer> ans){
        if(target==0){
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            if(i!=startIndex && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]<=target){
                ans.add(candidates[i]);
                helper(candidates,i+1,target-candidates[i],result,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
}