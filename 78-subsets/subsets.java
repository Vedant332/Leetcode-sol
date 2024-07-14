class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        
        helper(nums,0,ans,new ArrayList<>());
        return ans;
    }
   
    public void helper(int[] nums, int ind,List<List<Integer>> ans,List<Integer>res){
        if(ind==nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[ind]);
        helper(nums,ind+1,ans,res);
        res.remove(res.size()-1);
        helper(nums,ind+1,ans,res);
        
        }
    }