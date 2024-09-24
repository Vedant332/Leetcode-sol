class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int[][] visited=new int[m][n];
        int prevColor=image[sr][sc];
        if(prevColor==color) return image;
        dfs(image,sr,sc,color,m,n,prevColor);

        return image;
    }

    public void dfs(int[][] image,int row,int col,int color,int m, int n, int prevColor){
        image[row][col]=color;

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && image[nrow][ncol]==prevColor){
                dfs(image,nrow,ncol,color,m,n,prevColor);
            }
        }
    }
}