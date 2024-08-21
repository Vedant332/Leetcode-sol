class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n+1;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findPar(int u){
        if(parent.get(u)==u) return u;
        int node=findPar(parent.get(u));
        parent.set(u,node);
        return parent.get(node);
    }

    public void unionByRank(int u,int v){
        int ulp=findPar(u);
        int vlp=findPar(v);
        if(rank.get(ulp)<rank.get(vlp)){
            parent.set(ulp,vlp);
        }else if(rank.get(vlp)<rank.get(ulp)){
            parent.set(vlp,ulp);
        }else{
            parent.set(vlp,ulp);
            int rankU=rank.get(ulp);
            rank.set(ulp,rankU+1);
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds=new DisjointSet(edges.length);       
        for(int i=0;i<edges.length;i++){
            if(ds.findPar(edges[i][0])!=ds.findPar(edges[i][1])){
            ds.unionByRank(edges[i][0],edges[i][1]);
        }else{
            return new int[] {edges[i][0],edges[i][1]};
        }
        }
         return new int[]{};
    }
}