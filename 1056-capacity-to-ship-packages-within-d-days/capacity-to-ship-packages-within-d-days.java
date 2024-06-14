class Solution {
    private int possible(int[] weights, int target) {
    int total = 0;
    int count = 1;
    for(int w : weights) {
        total+=w;
        if(total > target) {
            count++;
            total = w;
        }
    }
    return count;
    }
    public int shipWithinDays(int[] weights, int D) {
         int min = 0, max = 0;
        for (int w : weights) {
            max += w;
            min = Math.max(w, min);
        }
        while (min <= max) {
            int mid = min + (max - min)/2;
            if (possible(weights,mid) > D) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }
}