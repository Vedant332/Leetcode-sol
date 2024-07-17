class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int i=0;i<matchsticks.length;i++){
            sum+=matchsticks[i];
        }
        if(sum%4!=0) return false;
        int subVal=sum/4;
        boolean[] visited = new boolean[matchsticks.length];
        return helper(matchsticks,0,0,subVal,visited,4);
    }

    public boolean helper(int[] nums,int ind,int currSum,int subVal,boolean[] visited,int k){
        if(k==0){
            return true;
        }

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