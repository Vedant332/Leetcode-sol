class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> time=new ArrayList<>();

        for(int i=0;i<timePoints.size();i++){
            String tm=timePoints.get(i);
            int hrs=60*(Integer.parseInt(tm.substring(0,2)));
            int mins=Integer.parseInt(tm.substring(3,tm.length()));
            time.add(hrs+mins);
        }

        Collections.sort(time);

        int result=Integer.MAX_VALUE;
        for(int i=1;i<time.size();i++){
            result=Math.min(result,time.get(i)-time.get(i-1));
        }

        return Math.min(result,(60*24)-time.get(time.size()-1)+time.get(0));
    }
}