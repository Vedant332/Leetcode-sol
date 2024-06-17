class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int lo=0;
        int hi=nums[nums.length-1]-nums[0];
        int ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(check(nums,p,mid)>=p){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }

    public int check(int[] nums,int p,int target){
        int count = 0;

        for(int i = 1 ; i < nums.length ; i++){
            if((nums[i]-nums[i-1]) <= target){
                count++;
                i++;
            }
        }
        return count;
    }
}