class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        Arrays.sort(nums);
        if(sum%k!=0) return false;
        int subVal=sum/k;
        boolean[] visited = new boolean[nums.length];
        return helper(nums,0,0,subVal,visited,k);
    }
    public boolean helper(int[] nums,int ind,int currSum,int subVal, boolean[] visited ,int k){
        if(k==0) return true;

        if(currSum==subVal){
            return helper(nums,0,0,subVal,visited,k-1);
        } 

       for(int i=ind;i<nums.length;i++){
        if(visited[i]!=true && currSum+nums[i]<=subVal){
            visited[i]=true;
            if(helper(nums,i+1,currSum+nums[i],subVal,visited,k)){
                return true;
            }
            visited[i]=false;
        }
       }
       return false;
    }
}