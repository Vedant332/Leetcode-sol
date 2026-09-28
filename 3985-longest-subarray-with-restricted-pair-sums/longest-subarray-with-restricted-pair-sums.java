class Solution {

    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int l = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            while (!checkValid(l, r, nums, map)) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }


    public boolean checkValid(int l,int r,int[] nums,HashMap<Integer, Integer> map) {
        int b = nums[r]; 
        for (int i = 1; i <= 500; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            int a = i;
            int target1 = b - a;
            if (map.containsKey(target1)) {
                if (a != target1) {
                    return false;
                }
                if (map.get(a) >= 2) {
                    return false;
                }
            }
            int target2 = a - b;
            if (map.containsKey(target2)) {
                return false;
            }
        }
        return true;
    }
}