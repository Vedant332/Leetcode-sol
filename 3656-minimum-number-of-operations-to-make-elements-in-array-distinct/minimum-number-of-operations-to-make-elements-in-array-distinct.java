class Solution {
    public int minimumOperations(int[] nums) {
       int len=nums.length;
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=len-1;i>=0;i--){
          map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
          if(map.get(nums[i])>1){
            return i/3+1;
          }
       }
       return 0;
    }
}