class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        vis[0][0]=true;
        int i=0;
        int j=0;
        int[] ans=new int[2];

        while(true){
            char ch=grid[i][j];
            ans[0]=i;
            ans[1]=j;

            if(ch=='R'){
                j=j+1;
            }else if(ch=='D'){
                i=i+1;
            }else if(ch=='U'){
                i=i-1;
            }else{
                j=j-1;
            }

            if(i < 0 || i >= m || j < 0 || j >= n){
                break;
            }
            if(vis[i][j]==true){
                break;
            }
            vis[i][j]=true;
        }
        return ans;
    }
}