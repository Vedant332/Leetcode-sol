class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();

        int[] currentVal=intervals[0];

        for(int i=1;i<intervals.length;i++){
            if(currentVal[1]<intervals[i][0]){
                ans.add(currentVal);
                currentVal=intervals[i];
            }else{
                currentVal[0]=Math.min(intervals[i][0],currentVal[0]);
                currentVal[1]=Math.max(intervals[i][1],currentVal[1]);
            }
        }
        ans.add(currentVal);
       return ans.toArray(new int[ans.size()][]);
    }
}