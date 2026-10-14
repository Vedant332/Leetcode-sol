class DisjointSet{
    ArrayList<Integer> parent;
    ArrayList<Integer> size;

    public DisjointSet(int n){
        parent=new ArrayList<>();
        size=new ArrayList<>();
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(parent.get(node)==node){
            return node;
        }

        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    public void unionBySize(int u,int v){
        int ulp_v=findUPar(v);
        int ulp_u=findUPar(u);
        if(ulp_v==ulp_u) return;
        if(size.get(ulp_v) > size.get(ulp_u)) {
        parent.set(ulp_u, ulp_v);
        size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
    } else {
        parent.set(ulp_v, ulp_u);
        size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
    }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
       int n = edges.length;
DisjointSet ds = new DisjointSet(n + 1);
 int[] ans=new int[2];

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(ds.findUPar(u)==ds.findUPar(v)){
                ans[0]=u;
                ans[1]=v;
            }else{
                ds.unionBySize(u,v);
            }
        }
        return ans;
    }
}