class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        List<int[]> ans=new ArrayList<>();
      int[] currentInterval=intervals[0];
      ans.add(currentInterval);
      for(int i=1;i<intervals.length;i++){
        if(currentInterval[1]>=intervals[i][0]){
            currentInterval[1]=Math.max(currentInterval[1],intervals[i][1]);
        }else{
            currentInterval=intervals[i];
            ans.add(currentInterval);
        }
      }
        return ans.toArray(new int[ans.size()][]);
    }
}