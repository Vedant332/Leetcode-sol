class Solution {
    public int candy(int[] r) {
         int n = r.length;
        if (n == 1) return 1; 

        int ans = n; 
        int i = 1;

        while (i < n) {
            
            if (r[i] == r[i - 1]) {
                i++;
                continue;
            }

          
            int peak = 0; 
            while (i < n && r[i] > r[i - 1]) {
                peak++;
                ans += peak;
                i++;
            }

            
            int down = 0; 
            while (i < n && r[i] < r[i - 1]) {
                down++;
                ans += down;
                i++;
            }

           
            ans -= Math.min(peak, down); 
        }

        return ans;
    }
}