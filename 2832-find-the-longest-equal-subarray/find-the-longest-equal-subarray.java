class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
     int len=0;
     int max=0;  
     int ans=0; 
     int j=0;
     Map<Integer,Integer> map =new HashMap<>();
     for(int i=0;i<nums.size();i++){
        map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
        max=Math.max(max,map.get(nums.get(i)));
        while((i - j + 1) - max > k){
            map.put(nums.get(j), map.get(nums.get(j)) - 1);
            j++;
        }
         ans=Math.max(max,ans);
     }
     return ans;
    }
}