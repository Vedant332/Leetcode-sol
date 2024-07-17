class Solution {
    String ans="";
    public String findDifferentBinaryString(String[] nums) {
         HashSet<String> hs = new HashSet<>();
        for (String num : nums) {
            hs.add(num);
        }
        StringBuilder sb = new StringBuilder();
        helper(nums.length, hs, 0, sb);
        return ans;
    }

    public boolean helper(int n, HashSet<String> hs, int ind, StringBuilder sb) {
        if (ind == n) {
            String candidate = sb.toString();
            if (!hs.contains(candidate)) {
                ans = candidate;
                return true;
            } else {
                return false;
            }
        }

        sb.append('0');
        if (helper(n, hs, ind + 1, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);

        sb.append('1');
        if (helper(n, hs, ind + 1, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);

        return false;
    }
}