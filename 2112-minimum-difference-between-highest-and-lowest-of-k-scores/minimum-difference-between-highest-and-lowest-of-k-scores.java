class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int i=0;
        int j=i+k-1;

        while(j<nums.length){
            diff=Math.min(diff,nums[j]-nums[i]);
            i++;
            j++;
        }
        return diff;
    }
}