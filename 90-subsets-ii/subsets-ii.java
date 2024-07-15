class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,0,ans,new ArrayList<>());
        return ans;
    }

    public void helper(int[] nums,int ind,List<List<Integer>> ans,List<Integer> res){
        ans.add(new ArrayList<>(res));

        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i-1]==nums[i]) continue;
            res.add(nums[i]);
            helper(nums,i+1,ans,res);
            res.remove(res.size()-1);
        }
    }
}