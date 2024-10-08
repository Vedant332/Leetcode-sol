class Solution {
    public int findTargetSumWays(int[] arr, int d) {
        int n=arr.length;
         int totSum=0;
        for(int i=0;i<arr.length;i++){
            totSum+=arr[i];
        }
         if ((totSum - d) < 0 || (totSum - d) % 2 != 0) {
            return 0;
        }
        int sum=(totSum-d)/2;
        
        int[][] dp=new int[n][sum+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return helper(arr,sum,arr.length-1,dp);
    }
    public static int helper(int[] arr,int sum,int ind,int[][] dp){
        if (ind == 0) {
            if (sum == 0 && arr[0] == 0) return 2; 
            if (sum == 0 || sum == arr[0]) return 1; 
            return 0;
        }
        
        
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        int notTake=helper(arr,sum,ind-1,dp);
        int take=0;
        if(arr[ind]<=sum){
            take=helper(arr,sum-arr[ind],ind-1,dp);
        }
        
        return dp[ind][sum]=(take+notTake);
    }
}