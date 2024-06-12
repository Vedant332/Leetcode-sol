class Solution {
    public int mySqrt(int x) {
        long lo=0;
        long hi=x;

        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            long sq=mid*mid;

            if( sq== x) return (int)mid;
            else if(sq < x) lo=mid+1;
            else hi=mid-1;
        }
        return (int)hi;
    }
}