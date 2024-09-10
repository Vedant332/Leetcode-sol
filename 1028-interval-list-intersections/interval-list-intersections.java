class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans=new ArrayList<>();
        int i=0;
        int j=0;

        while(i<firstList.length && j<secondList.length){
            if(firstList[i][1]<secondList[j][0]){
                i++;
            }else if(firstList[i][0]>secondList[j][1]){
                j++;
            }else{
                int a=Math.max(firstList[i][0],secondList[j][0]);
                int b=Math.min(firstList[i][1],secondList[j][1]);
                ans.add(new int[]{a,b});
                if(firstList[i][1]<secondList[j][1]){
                    i++;
                }else{
                    j++;
                }
            }
        }
        int k=0;
        int[][] res=new int[ans.size()][];
        for(int[] row : ans){
            res[k]=row;
            k++;
        }
        return res;
    }
}