class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(nums1,nums2,0,0,dp);
    }

    public int helper(int[] nums1,int[] nums2,int ind1,int ind2,int[][] dp){
        if(ind1>=nums1.length || ind2>=nums2.length) return 0;

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        if(nums1[ind1]==nums2[ind2]){
            return dp[ind1][ind2]=1+helper(nums1,nums2,ind1+1,ind2+1,dp);
        }else{
            return dp[ind1][ind2]=Math.max(helper(nums1,nums2,ind1+1,ind2,dp),helper(nums1,nums2,ind1,ind2+1,dp));
        }
    }
}