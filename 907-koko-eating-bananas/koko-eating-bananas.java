class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=0;
        for(int i=0;i<piles.length;i++){
            hi=Math.max(hi,piles[i]);
        }

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int hrs=isValid(mid,piles);

            if(hrs>h){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }

    public int isValid(int k,int[] piles){
       int totalTime=0;
        for(int i=0;i<piles.length;i++){
            totalTime+=Math.ceil((double)piles[i]/(double)k);
        }
        return totalTime;
    }
} 