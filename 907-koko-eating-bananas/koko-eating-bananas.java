class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=1;
        for(int i=0;i<piles.length;i++){
            max=Math.max(piles[i],max);
        }

        int lo=1;
        int hi=max;
        int ans=max;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(func(piles,mid)<=h){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }

    public long func(int[] nums, long k){
        long totalhrs=0;

        for(int i=0;i<nums.length;i++){
            totalhrs+=(nums[i] + k - 1)/k;
        }
        return totalhrs;
    }
}