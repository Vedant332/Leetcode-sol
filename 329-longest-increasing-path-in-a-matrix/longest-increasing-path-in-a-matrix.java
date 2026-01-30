class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int maxPath=0;
        int[][] dp=new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row ,-1);
        }

        if(m==1 && n==1) return 1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int path=dfs(i,j,m,n,matrix,dp);
                maxPath=Math.max(maxPath,path);
            }
        }
        return maxPath;
    }

    public int dfs(int row,int col,int m,int n,int[][] matrix,int[][] dp){

        if(dp[row][col]!=-1) return dp[row][col];

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int max=1;


        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && matrix[nrow][ncol]>matrix[row][col]){
                int len=1+dfs(nrow,ncol,m,n,matrix,dp);
                max=Math.max(max,len);
            }
        }
        return dp[row][col]=max;
    }
}