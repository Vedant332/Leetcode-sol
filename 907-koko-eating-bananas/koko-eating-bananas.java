class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }

        int lo=1;
        int hi=max;

        while(lo<=hi){
            int mid=(lo+hi)/2;
            int totalhrs=func(piles,mid);
            if(totalhrs<=h){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }

    public int func(int[] piles,int k){
        int totalTime=0;
        for(int i=0;i<piles.length;i++){
            totalTime+=Math.ceil((double)piles[i]/(double)k);
        }
        return totalTime;
    }
}