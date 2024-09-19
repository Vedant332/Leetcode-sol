class Solution {
    public int splitArray(int[] nums, int k) {
        int totSum=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            totSum+=nums[i];
            maxi=Math.max(nums[i],maxi);
        }
        int lo=maxi;
        int hi=totSum;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(func(nums,mid) <= k){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public int func(int[] nums,int mid){
        int sum=nums[0];
        int k=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]+sum<=mid){
                sum+=nums[i];
            }else{
                k++;
                sum=nums[i];
            }
        }
        return k;
    }
}