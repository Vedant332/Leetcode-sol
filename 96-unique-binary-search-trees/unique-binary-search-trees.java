class Solution {
    private int[] memo = new int[20];
    public int numTrees(int n) {
        if(n<=1) return 1;

        if(memo[n]!= 0) return memo[n];
        int ans=0;

        for(int i=1;i<=n;i++){
            ans+=numTrees(i-1)*numTrees(n-i);
        }

        return memo[n]=ans;
    }
}