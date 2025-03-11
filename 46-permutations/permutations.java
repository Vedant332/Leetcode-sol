class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        helper(0,nums,ans,new ArrayList<>(),visited);
        return ans;
    }

    public void helper(int ind,int[] nums,List<List<Integer>> ans,List<Integer> temp,boolean[] visited){
        if(ind==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]==true) continue;
            temp.add(nums[i]);
            visited[i]=true;
            helper(ind+1,nums,ans,temp,visited);
            visited[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}