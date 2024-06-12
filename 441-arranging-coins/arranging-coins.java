class Solution {
    public int arrangeCoins(int n) {
        long lo=0;
        long hi=n;

        while(lo<=hi){
            long mid=lo+(hi-lo)/2;

            long steps=mid * (mid + 1) / 2;

            if(steps==n) return (int)mid;
            else if(steps>n) hi=mid-1;
            else lo=mid+1;
         }
         return (int)hi;
    }
}