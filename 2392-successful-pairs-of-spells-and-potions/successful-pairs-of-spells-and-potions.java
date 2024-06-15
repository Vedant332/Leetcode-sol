class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int res = countSuccessfulPairs(spells[i], potions, success);
            ans[i] = res;
        }
        return ans;
    }

    public int countSuccessfulPairs(int spell, int[] potions, long success) {
        int n = potions.length;
        int lo = 0;
        int hi = n;

        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if ((long) spell * potions[mid] >= success) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return n - lo;
    }
}