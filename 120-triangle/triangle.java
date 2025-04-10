class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return func(0,0,triangle,n,dp);
    }
    public int func(int i,int j,List<List<Integer>> triangle,int n,int[][] dp){
        if(i==n-1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j]!=-1) return dp[i][j];
        int val=triangle.get(i).get(j);
        int down=val+func(i+1,j,triangle,n,dp);
        int right=val+func(i+1,j+1,triangle,n,dp);

        return dp[i][j]=Math.min(down,right);
    }
}