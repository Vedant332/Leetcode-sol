class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int j=1;
        int i=0;

        while(j<n){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }else{
                j++;
            }
        }
        return i+1;
    }
}