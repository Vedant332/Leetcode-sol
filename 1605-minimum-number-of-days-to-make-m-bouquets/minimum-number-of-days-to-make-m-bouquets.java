class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int hi=0;
        int lo=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            hi=Math.max(hi,bloomDay[i]);
            lo=Math.min(lo,bloomDay[i]);
        }
        int ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(possible(bloomDay,mid,m,k)==true){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }

    public boolean possible(int[] arr,int mid,int m,int k){
        int count=0;
        long totalFlowers=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
            }else{
                totalFlowers+=count/k;
                count=0;
            }
        }
        totalFlowers += count / k;

        if(totalFlowers>=m) return true;
        else return false;
    }
}