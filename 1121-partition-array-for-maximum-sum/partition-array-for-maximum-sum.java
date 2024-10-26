class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return func(0,arr,k,n,dp);
    }

    public int func(int ind,int[] arr,int k,int n,int[] dp){
        if(ind==n) return 0;

        if(dp[ind]!=-1) return dp[ind];
        int len=0;
        int maxi=Integer.MIN_VALUE;
        int maxAs=0;
        for(int i=ind;i<Math.min(n,ind+k);i++){
            len++;
            maxi=Math.max(maxi,arr[i]);
            int sum=len*maxi+func(i+1,arr,k,n,dp);
            maxAs=Math.max(maxAs,sum);
        }
        return dp[ind]=maxAs;
    }
}