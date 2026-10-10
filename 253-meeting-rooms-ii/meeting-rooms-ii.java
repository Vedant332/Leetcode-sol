class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)-> Integer.compare(a,b));
        pq.offer(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            if(!pq.isEmpty() && pq.peek()<=intervals[i][0]){
                pq.poll();
            }
             pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}