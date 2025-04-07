class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int subsets=1<<nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<=subsets-1;i++){
            List<Integer> ls=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i & (1<<j))!=0) ls.add(nums[j]);
            }
            ans.add(ls);
        }
        return ans;
    }
}