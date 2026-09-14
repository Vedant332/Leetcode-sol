class Solution {
    public long shadowPairs(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        long pairs = 0;
        long totalCount = 0;
        for (int x : nums) {
            while (!stack.isEmpty() && stack.peek()[0] > x) {
                totalCount -= stack.peek()[1];
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek()[0] == x) {
                pairs += totalCount - stack.peek()[1];
                stack.peek()[1]++;
                totalCount++;
            }
            else {
                pairs += totalCount;
                stack.push(new int[]{x, 1});
                totalCount++;
            }
        }
        return pairs;
    }
}