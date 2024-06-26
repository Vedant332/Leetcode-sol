class Solution {
    public int removeDuplicates(int[] nums) {
       int ptr = 0;
        int move = 1;

        while (move != nums.length) {
            if (nums[ptr] != nums[move]) {
                ptr++;
                nums[ptr] = nums[move];
            } else move++;
        }
        return ptr + 1;
    }
}