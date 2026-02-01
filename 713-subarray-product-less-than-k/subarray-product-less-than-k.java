class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod=1;
        int n=nums.length;
        int i=0;
        int j=0;
        int count=0;
        while(j<n){
            prod=prod*nums[j];

            while(prod>=k && i<=j){
                prod=prod/nums[i];
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}