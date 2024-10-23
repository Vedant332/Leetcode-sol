class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[n];
        int[] par=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            par[i]=i;
        }

        int maxEle=0;
        int ind=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<1+dp[j]){
                    dp[i]=1+dp[j];
                    par[i]=j;
                }
            }
            if(maxEle<dp[i]){
                maxEle=dp[i];
                ind=i;
            }
        }

        List<Integer> ans=new ArrayList<>();
        while(par[ind]!=ind){
            ans.add(nums[ind]);
            ind=par[ind];
        }
        ans.add(nums[ind]);

        return ans;
    }
}