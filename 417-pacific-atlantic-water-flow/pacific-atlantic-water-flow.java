class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;
        int[][] pacific=new int[m][n];
        int[][] atlantic=new int[m][n];

        for(int i=0;i<m;i++){
            dfs(i,0,pacific,m,n,heights,-1);
            dfs(i,n-1,atlantic,m,n,heights,-1);
        }
        for(int j=0;j<n;j++){
            dfs(0,j,pacific,m,n,heights,-1);
            dfs(m-1,j,atlantic,m,n,heights,-1);
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
    public void dfs(int row,int col,int[][] arr,int m,int n,int[][] heights,int prev){
        if(row<0 || row>=m || col<0 || col>=n || heights[row][col]<prev || arr[row][col]==1) return;

        arr[row][col]=1;
        dfs(row-1,col,arr,m,n,heights,heights[row][col]);
        dfs(row,col+1,arr,m,n,heights,heights[row][col]);
        dfs(row+1,col,arr,m,n,heights,heights[row][col]);
        dfs(row,col-1,arr,m,n,heights,heights[row][col]);
    }
}