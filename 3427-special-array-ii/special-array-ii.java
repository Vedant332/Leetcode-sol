class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] cumSum=new int[nums.length];

        for(int i=1;i<nums.length;i++){
            if(nums[i]%2 == nums[i-1]%2){
                cumSum[i]=cumSum[i-1]+1;
            }else{
                cumSum[i]=cumSum[i-1];
            }
        }
        boolean[] result=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            if(cumSum[end]-cumSum[start]==0){
                result[i]=true;
            }else{
                result[i]=false;
            }
        }
        return result;
    }
}