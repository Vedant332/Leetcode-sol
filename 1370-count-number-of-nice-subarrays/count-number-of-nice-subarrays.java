class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return func(nums,k)-func(nums,k-1);
    }

    public int func(int[] nums,int goal){
        int i=0;
        int j=0;
        int sum=0;
        int count=0;

        while(j<nums.length){
            sum+=(nums[j]%2);

            while(goal<sum){
                sum-=(nums[i]%2);
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}