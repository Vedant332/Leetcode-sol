class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;
        int[][] pacific=new int[m][n];
        int[][] atlantic=new int[m][n];

        for(int i=0;i<m;i++){
            dfs(i,0,heights,pacific,m,n);
            dfs(i,n-1,heights,atlantic,m,n);
        }

        for(int j=0;j<n;j++){
            dfs(0,j,heights,pacific,m,n);
            dfs(m-1,j,heights,atlantic,m,n);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                     List<Integer> res=new ArrayList<>();
                     res.add(i);
                     res.add(j);
                     ans.add(res);
                }
            }
        }
        return ans;
    }

    public void dfs(int row,int col,int[][] heights,int[][] arr,int m,int n){
        arr[row][col]=1;

            int[] dx={0,-1,0,1};
             int[] dy={-1,0,1,0};
             for(int i=0;i<4;i++){
                int nrow=dx[i]+row;
                int ncol=dy[i]+col;
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && arr[nrow][ncol]==0 && heights[nrow][ncol]>=heights[row][col]){
                    dfs(nrow,ncol,heights,arr,m,n);
                }
             }
    }
}