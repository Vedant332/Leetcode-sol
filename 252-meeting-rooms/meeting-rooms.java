class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i=1;i<intervals.length;i++){
            int[] temp=intervals[i-1];
            int[] next=intervals[i];
            if(temp[1]>next[0]) return false;
        }
        return true;
    }
}