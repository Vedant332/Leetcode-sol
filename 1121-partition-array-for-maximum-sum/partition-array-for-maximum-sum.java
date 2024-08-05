class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length+1];
        Arrays.fill(dp,-1);

        dp[arr.length]=0;

        for(int ind=arr.length-1;ind>=0;ind--){
            int sum=0;
        int maxSum=0;
        int maxEle=Integer.MIN_VALUE;
        for(int i=0;i<Math.min(k,arr.length-ind);i++){
            maxEle=Math.max(maxEle,arr[ind+i]);
            sum=maxEle*(i+1) + dp[ind+i+1];
            maxSum=Math.max(sum,maxSum);
        }
        dp[ind]=maxSum;
        }
        
        return dp[0];
    }

    // public int func(int[] arr,int k, int ind,int[] dp){
    //     if(ind>=arr.length) return 0;

    //      if (dp[ind] != -1) return dp[ind];

    //     int sum=0;
    //     int maxSum=0;
    //     int maxEle=Integer.MIN_VALUE;
    //     for(int i=0;i<Math.min(k,arr.length-ind);i++){
    //         maxEle=Math.max(maxEle,arr[ind+i]);
    //         sum=maxEle*(i+1) + func(arr,k,ind+i+1,dp);
    //         maxSum=Math.max(sum,maxSum);
    //     }
    //     return dp[ind]=maxSum;
    // }
}