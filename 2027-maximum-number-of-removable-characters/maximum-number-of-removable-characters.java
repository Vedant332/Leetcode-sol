class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
       int lo = 0;
        int hi = removable.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            String afterRemoval = remove(s, removable, mid);
            if (isSub(p, afterRemoval)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo - 1;
    }

    // Helper function to remove k characters from s as per the removable array
    private String remove(String s, int[] removable, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            chars[removable[i]] = '\0'; // Use null character to mark removal
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '\0') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Helper function to check if p is a subsequence of s
    private boolean isSub(String p, String s) {
        int i = 0, j = 0;
        while (i < p.length() && j < s.length()) {
            if (p.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == p.length();
    }
}