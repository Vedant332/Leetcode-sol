class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        if(k==0){
            for(int i=1;i<nums.length;i++){
                if(nums[i]==0 && nums[i-1]==0){
                    return true;
                }
            }
        }

        map.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum%k)){
                if(i-map.get(sum%k)>1){
                    return true;
                }
            }
            map.putIfAbsent(sum%k,i);
        }
        return false;
    }
}