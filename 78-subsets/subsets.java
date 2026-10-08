class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int ind,int[] nums,List<Integer> temp, List<List<Integer>> ans){
        if(ind==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[ind]);
        helper(ind+1,nums,temp,ans);
        temp.remove(temp.size()-1);
        helper(ind+1,nums,temp,ans);
    }
}