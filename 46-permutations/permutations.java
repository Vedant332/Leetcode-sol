class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] seen=new boolean[nums.length];
        Arrays.fill(seen,false);
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,seen,ans,new ArrayList<>());
        return ans;
    }

    public void helper(int[] nums,boolean[] seen,List<List<Integer>> ans,List<Integer> res){
        if(res.size()==nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(seen[i]==false){
                seen[i]=true;
                res.add(nums[i]);
                helper(nums,seen,ans,res);
                res.remove(res.size()-1);
                seen[i]=false;
            }
        }
    }
}