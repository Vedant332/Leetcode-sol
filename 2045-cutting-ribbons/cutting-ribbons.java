class Solution {
    public int maxLength(int[] ribbons, int k) {
        int maxEle=Integer.MIN_VALUE;
        for(int i=0;i<ribbons.length;i++){
            maxEle=Math.max(maxEle,ribbons[i]);
        }
        int lo=1;
        int hi=maxEle;
        int ans=0;

        while(lo<=hi){
         int mid=lo+(hi-lo)/2;
            if(check(ribbons,mid,k)){
                lo=mid+1;
                ans=Math.max(ans,mid);
            }else{
                hi=mid-1;
            }
        }
        return ans;
    }

    public boolean check(int[] ribbons,int mid,int k){
        int splitRibbon=0;
        for(int i=0;i<ribbons.length;i++){
            int NosplitRibbon=ribbons[i]/mid;
                splitRibbon+= NosplitRibbon;
                if(splitRibbon>=k) return true;
            
        }
            return false;
    }
}