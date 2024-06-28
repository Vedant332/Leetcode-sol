class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int i = 0, j = 0, ans = 0 ;
        while( j < n ){
            int num = nums[j];
            if( !map.containsKey(num) )
                map.put(num ,1);
            else
                map.put(num , map.get(num) +1);
            
            
            while( map.get(num) > k ){
                int rm = nums[i++];
                map.put(rm, map.get(rm) -1 );
                if( map.get(rm) == 0 )
                    map.remove(rm);
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        
        return ans;
    }
}