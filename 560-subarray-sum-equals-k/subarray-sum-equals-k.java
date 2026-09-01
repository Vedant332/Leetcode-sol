class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int curSum=0;
        int result=0;
        for(int i=0;i<n;i++){
            curSum+=nums[i];
            if(map.containsKey(curSum-k)){
                result=result + map.get(curSum-k);
            }
            map.put(curSum,map.getOrDefault(curSum,0)+1);
        }
        return result;
    }
}