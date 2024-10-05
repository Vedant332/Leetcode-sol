class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        ArrayList<Integer> left=new ArrayList<>();
        ArrayList<Integer> right=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i!=0) right.add(nums[i]);
            if(i!=n-1) left.add(nums[i]);
        }

        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        return Math.max(func(left,left.size()-1,dp1),func(right,right.size()-1,dp2));
    }

    public int func(ArrayList<Integer> arr,int ind,int[] dp){
        if(ind==0) return arr.get(ind);

        if(dp[ind]!=-1) return dp[ind];
        int notTake=func(arr,ind-1,dp);
        int take=arr.get(ind);
        if(ind-2>=0){
            take+=func(arr,ind-2,dp);
        }

        return dp[ind]=Math.max(take,notTake);
    }
}