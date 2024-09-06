class DisjointSet{
    ArrayList<Integer> parent=new ArrayList<>();
    ArrayList<Integer> size=new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int u){
        if(parent.get(u) == u) return u;

        int node=findUPar(parent.get(u));
        parent.set(u,node);
        return parent.get(u);
    }

    public void unionBySize(int u,int v){
        int ulp_v=findUPar(v);
        int ulp_u=findUPar(u); 
        if(ulp_v==ulp_u) return;
        if(size.get(ulp_v)<size.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_v)+size.get(ulp_u));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int[] dx={-1, 0, 1, 0};
                    int[] dy={0, -1, 0, 1};
                    for(int k=0;k<4;k++){
                        int nrow=i+dx[k];
                        int ncol=j+dy[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                            ds.unionBySize(i*n+j,nrow*n+ncol);
                        }
                    }
                }
            }
        }

        int maxi=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> hs=new HashSet<>();
                    int[] dx={-1, 0, 1, 0};
                    int[] dy={0, -1, 0, 1};
                    for(int k=0;k<4;k++){
                        int nrow=i+dx[k];
                        int ncol=j+dy[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                            hs.add(ds.findUPar(nrow*n+ncol));
                        }
                    }
                    int sizeTot=0;
                    for(Integer it : hs){
                        sizeTot+=ds.size.get(it);
                    }
                    maxi=Math.max(maxi,sizeTot+1);
                }
            }
        }
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            maxi = Math.max(maxi, ds.size.get(ds.findUPar(cellNo)));
        }
        return maxi;
    }
}