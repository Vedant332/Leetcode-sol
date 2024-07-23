class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        
       for(int i=0;i<nums.length;i++){
        if(i!=0) arr1.add(nums[i]);
        if(i!=nums.length-1) arr2.add(nums[i]);
       }
        return Math.max(func2(arr1,dp1),func2(arr2,dp2));
    }

   
    public int func2( ArrayList<Integer> arr,int[] dp){
        dp[0]=arr.get(0);

        for(int i=1;i<arr.size();i++){
            int take=arr.get(i);
            if(i!=1) take+=dp[i-2];
            int notTake=dp[i-1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[arr.size()-1];
    }
}