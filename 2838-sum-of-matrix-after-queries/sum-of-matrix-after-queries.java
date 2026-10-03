class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long sum=0;
        int len=queries.length;
        Set<Integer> rows=new HashSet<>();
        Set<Integer> col=new HashSet<>();
        for(int i=len-1;i>=0;i--){
            int type=queries[i][0];
            int index=queries[i][1];
            int val=queries[i][2];

            if(type==0){
                if(!rows.contains(index)){
                    sum=sum+(val*(n-col.size()));
                    rows.add(index);
                }
            }else{
                if(!col.contains(index)){
                    sum=sum+(val*(n-rows.size()));
                    col.add(index);
                }
            }
        }
        return sum;
    }
}