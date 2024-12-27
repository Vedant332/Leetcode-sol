class Solution {
    public int maxScoreSightseeingPair(int[] values) {
       int maxTillNow=values[0]+0;
       int res=0;
       for(int j=1;j<values.length;j++){
        int x=values[j]-j;
        
        res=Math.max(res,maxTillNow+x);

        maxTillNow=Math.max(maxTillNow,values[j]+j);
       }
       return res;
    }
}