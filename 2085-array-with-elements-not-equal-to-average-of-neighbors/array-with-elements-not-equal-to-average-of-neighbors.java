class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Arrays.sort(nums);
        // for(int i=1;i<nums.length-1;i=i+2){
        //     int temp=nums[i];
        //     nums[i]=nums[i-1];
        //     nums[i-1]=temp;
        // }
        // return nums;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=1;i<n;i=i+2)
        {
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
        }
        return nums;
    }
}