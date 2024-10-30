class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        return sumSubMax(nums, n) - sumSubMin(nums, n);
    }

    public long sumSubMax(int[] nums, int n) {
        int[] nge = getNGE(nums, n);
        int[] pge = getPGE(nums, n);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            int leftGreater = pge[i];
            int rightGreater = nge[i];

            long totalWays = (long) (i - leftGreater) * (rightGreater - i);
            sum += totalWays * (long) nums[i];
        }
        return sum;
    }

    public long sumSubMin(int[] nums, int n) {
        int[] nse = getNSE(nums, n);
        int[] pse = getPSE(nums, n);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            int leftSmaller = pse[i];
            int rightSmaller = nse[i];

            long totalWays = (long) (i - leftSmaller) * (rightSmaller - i);
            sum += totalWays * (long) nums[i];
        }
        return sum;
    }

    public int[] getNSE(int[] nums, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] getPSE(int[] nums, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] getPGE(int[] nums, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] getNGE(int[] nums, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
}