class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {    
        int m=image.length;
        int n=image[0].length;
        int prevColor=image[sr][sc];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==sr && j==sc){
                    dfs(image,sr,sc,color,m,n,prevColor);
                }
            }
        }
        return image;
    }

    public void dfs(int[][] image, int sr,int sc,int color,int m,int n,int prevColor){
        image[sr][sc]=color;

        int[] dx={0,-1,0,1};
        int[] dy={-1,0,1,0};
        for(int i=0;i<4;i++){
            int nrow=dx[i]+sr;
            int ncol=dy[i]+sc;
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && image[nrow][ncol]!=color && image[nrow][ncol]==prevColor){
                dfs(image,nrow,ncol,color,m,n,prevColor);
            }
        }
    }
}