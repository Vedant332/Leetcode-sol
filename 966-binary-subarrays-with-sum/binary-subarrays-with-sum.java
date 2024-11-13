class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums,goal)-func(nums,goal-1);

    }

    public int func(int[] nums,int goal){
        if(goal<0) return 0;
        int n=nums.length;
        int i=0;
        int j=0;
        int sum=0;
        int count=0;

        while(j<nums.length){
            sum+=nums[j];

            while(goal<sum){
                sum-=nums[i];
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}